package com.futureAndThread;

public class Client {
    //这是一个异步方法，返回的DataInterface接口是一个Future
    public DataInterface request(final String queryStr) {//返回DataInterface结果
        final FutureData future = new FutureData();//返回FutureData对象
        System.out.println(Thread.currentThread().getName() + "Thread.currentThread().getName()Client" );

        //开启RealDataThread
        new Thread(() -> {
            System.out.println("Client...............RealData的构建很慢，所以在单独的线程中进行");
            RealData realdata = new RealData(queryStr);
            System.out.println("Client.................setRealData()的时候会notify()等待在这个future上的对象");
            future.setRealData(realdata);//装配置realdata
        }).start();
        System.out.println("Client.....................FutureData会被立即返回，不会等待RealData被构造完");
        return future;
    }
}