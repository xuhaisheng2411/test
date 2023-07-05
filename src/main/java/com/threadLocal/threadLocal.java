package com.threadLocal;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 17:04
 * @Version: 1.0
 */
public class threadLocal {

    //创建线程私有变量
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    private static Integer param=0;
    public static void main(String[] args) {
        //定义公共任务
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                //当前线程的线程名称
                String tname=Thread.currentThread().getName();
                System.out.println(tname+"设置值："+tname);
                //设置线程的名称
                threadLocal.set(tname);
                ++param;
                System.out.println("param："+param);
                System.out.println("threadLocal："+threadLocal.get());

            }
        };
        Thread t1=new Thread(runnable);
        t1.start();
        Thread t2=new Thread(runnable);
        t2.start();
        Thread t3=new Thread(runnable);
        t3.start();
    }

}
