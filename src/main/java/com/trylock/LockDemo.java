package com.trylock;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/27 0027 11:27
 * @Version: 1.0
 */

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    // new一个锁对象，注意此处必须声明成类对象，保持只有一把锁,ReentrantLock是Lock的唯一实现类
    Lock lock = new ReentrantLock();

    public void testLock(){

        boolean flag = false;
        try{
            System.out.println("1===="+Thread.currentThread().getName());
            flag = lock.tryLock(1, TimeUnit.SECONDS);
            if (flag){
                System.out.println("占有对象：lock");
                System.out.println("进行5秒的业务操作");
                Thread.sleep(5000);
            }else{
                System.out.println("经过1秒钟的努力，还没有占有对象，放弃占有");
            }
            System.out.println("2===="+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if (flag){
                System.out.println( "释放对象：lock");
                lock.unlock();
            }
        }
    }

    public void demo(){


        //第一种写法（最简单）：使用工厂类Executors快速创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();


        //第二种写法（最原始）：使用ExecutorService创建线程池
        ExecutorService pool = new ThreadPoolExecutor(
                0,      //corePoolSize = 0
                Integer.MAX_VALUE,  //maximumPoolSize = 2147483647
                60L,   //keepAliveTime = 60
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());



        //第三种写法（适中）：使用ThreadPoolTaskExecutor简洁创建线程池
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setQueueCapacity(0); //这个地方随便填
        poolTaskExecutor.setCorePoolSize(0);  //核心线程数是0，阻塞队列会选择new SynchronousQueue()
        poolTaskExecutor.setMaxPoolSize(2147483647);  // Integer.MAX_VALUE = 2147483647
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        poolTaskExecutor.setKeepAliveSeconds(60);
        poolTaskExecutor.initialize();





        // 创建数量可变的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // 提交5个任务
        System.out.println("0===="+Thread.currentThread().getName());
        for(int i=0; i<5; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("0.5===="+Thread.currentThread().getName());

                    testLock();
                }
            });
        }
        // 释放线程池中的线程
        service.shutdown();
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.demo();
    }

}
