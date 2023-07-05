package com.futureAndThread;

public class mainTest {
    public static void main(String[] args) {


        /**
         * @Author Administrator
         * @Desctription TODO
         * @Date 2022/4/19 0019 11:14
         * @Param
         * 一个典型的Future模式由以下几个部分组成：
         * Main：系统启动，调用Client发出请求
         * Client：返回Data对象，立即返回FutureData，并开启ClientThread线程装配RealData
         * Data：返回数据的接口
         * FutureData：Future数据，构造很快，但是是一个虚拟的数据，需要装配RealData，好比一个订单
         * RealData：真实数据，其构造是比较慢的，好比上面例子中的肯德基午餐
         * @return
         */
       // System.out.println(Thread.currentThread().getName() + "Thread.currentThread().getName()main" );
/*        Client client = new Client();
        //这里会立即返回，因为得到的是FutureData而不是RealData
        DataInterface data = client.request("name");*/

        final FutureData future = new FutureData();//返回FutureData对象
        new Thread(() -> {
            RealData realdata = new RealData("oscar");
            System.out.println("main.................realdata装配完成，去setRealData，给代理处理。");
            future.setRealData(realdata);//装配置realdata
        }).start();
        try {
            //这里可以用一个sleep代替了对其他业务逻辑的处理
            System.out.println("main.................主逻辑业务开始");
            Thread.sleep(10000);
            System.out.println("main.................主逻辑业务10秒结束OVER");
        } catch (InterruptedException e) {
        }
        //使用真实的数据，如果到这里数据还没有准备好，getResult()会等待数据准备完，再返回
       System.out.println("main.................数据结果 = " + future.getResult());
    }
}
