package com.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/23 0023 18:12
 * @Version: 1.0  主线程修改了true  子线程volatile共享可见性 才能停止循环
 */
public class volatile1 {

/*    private  volatile boolean stopThread;*/
    private static volatile boolean stopThread;
    public static void main(String[] args) throws InterruptedException {

        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (!stopThread) {
                    i++;
                    System.out.println("i++");
                }
            }
        });
        System.out.println("stopThread"+stopThread);
        TimeUnit.SECONDS.sleep(5);
        th.start();
        TimeUnit.SECONDS.sleep(1);
        stopThread = true;
        System.out.println("gaiwanhou");

    }
}