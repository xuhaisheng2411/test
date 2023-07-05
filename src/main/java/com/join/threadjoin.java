package com.join;

/**
 * @Author: Administrator
 * @Desctription: TODO  join相当于vip插队 待此线程执行完成之后，再执行其他线程，其他线程阻塞
 * @Date: Created in 2022/4/19 0019 16:50
 * @Version: 1.0
 */
public class threadjoin {
    static int count=0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "main" );
        Thread t1 = new Thread(()->{
            System.out.println("Thread t1 run");
            System.out.println(Thread.currentThread().getName() + "Thread" );
            count=10;
        });
        t1.start();
        //t1.join();//若把这一行注释掉，则打印的count为0
        System.out.println("count="+count);
        Thread.sleep(2000);
        System.out.println("count="+count);
    }
}
