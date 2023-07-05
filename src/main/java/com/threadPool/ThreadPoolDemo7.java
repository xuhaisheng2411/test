package com.threadPool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/11/16 0016 15:05
 * @Version: 1.0
 */
public class ThreadPoolDemo7 {
    public static void main(String[] args) {
        //创建线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        System.out.println("添加任务的时间：" + LocalDateTime.now());
        //执行定时任务（延迟3s执行）只执行一次
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行子任务：" + LocalDateTime.now());
            }
        }, 3, TimeUnit.SECONDS);


        System.out.println("添加任务时间：" + LocalDateTime.now());
        //2s之后开始执行定时任务，定时任务每隔4s执行一次
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务：" + LocalDateTime.now());
            }
        }, 2, 4, TimeUnit.SECONDS);
    }


}

