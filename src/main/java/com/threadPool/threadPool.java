package com.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/11/16 0016 14:56
 * @Version: 1.0
 */
public class threadPool {


    // spring创建线程池的几种方式



    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        //添加任务方式 1
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        //添加任务方式2
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });






    ExecutorService threadPool2 =  Executors.newFixedThreadPool(2);
    //执行任务
    Future<Integer> result = threadPool2.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            int num = new Random().nextInt(10);
            System.out.println("随机数" + num);
            return num;
        }
    });

    //打印线程池返回方式
        try {
            System.out.println("返回结果：" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}