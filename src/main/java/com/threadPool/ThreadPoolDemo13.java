package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Administrator
 * @Desctription: TODO 根据当前CPU⽣成线程池
 * @Date: Created in 2022/11/16 0016 15:10
 * @Version: 1.0
 */
public class ThreadPoolDemo13 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                System.out.println("线程名" + Thread.currentThread().getName());
            });

            while(!service.isTerminated()) {
            }
        }
    }
}
