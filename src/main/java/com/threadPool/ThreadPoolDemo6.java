package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/11/16 0016 15:03
 * @Version: 1.0
 */
public class ThreadPoolDemo6 {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.submit(() -> {
                System.out.println("i : " + finalI + "|线程名称：" + Thread.currentThread().getName());
            });
        }
    }
}

