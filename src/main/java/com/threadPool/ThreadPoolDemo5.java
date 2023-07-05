package com.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/11/16 0016 15:01
 * @Version: 1.0
 */
public class ThreadPoolDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                //！！！！！！！一定要注意：要把任务Runnable设置给新创建的线程
                Thread thread = new Thread(r);
                //设置线程的命名规则
                thread.setName("我的线程" + r.hashCode());
                //设置线程的优先级
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(2,threadFactory);
        //执行任务1
        Future<Integer> result = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println(Thread.currentThread().getPriority() + ", 随机数：" + num);
                return num;
            }
        });
        //打印线程池返回结果
        System.out.println("返回结果：" + result.get());
    }
}