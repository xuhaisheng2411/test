package com.threadJoin;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/27 0027 10:44
 * @Version: 1.0
 */
public class join {
    public static void main(String[] args) throws Exception {
        ThreadTest test  =new ThreadTest();
        ThreadTest test2  =new ThreadTest();
        test.setName("one");
        test2.setName("two");
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test2);
        t1.start();
        /**
         * 主线程向下转时，碰到了t1.join(),t1要申请加入到运行中来，就是要CPU执行权。
         * 这时候CPU执行权在主线程手里，主线程就把CPU执行权给放开，陷入冻结状态。
         * 活着的只有t1了，只有当t1拿着执行权把这些数据都打印完了，主线程才恢复到运行中来
         */
        //join 方法 确保 t1执行之后 执行t2
       t1.join();
        //t1.yield();//有点谦让 的意思。不长时间占用线程
        t2.start();

    }
}
class ThreadTest implements Runnable{

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(this.getName()+"------"+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
