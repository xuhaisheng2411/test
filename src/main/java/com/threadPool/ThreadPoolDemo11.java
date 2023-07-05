package com.threadPool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Administrator
 * @Desctription: TODO  定时任务单线程
 * @Date: Created in 2022/11/16 0016 15:08
 * @Version: 1.0
 */
public class ThreadPoolDemo11 {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("添加任务的时间:" + LocalDateTime.now());
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行时间：" + LocalDateTime.now());
            }
        },2, TimeUnit.SECONDS );



       //单线程线程池
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }


    }
}
