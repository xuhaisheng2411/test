package com.async2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.Future;

@Service
public class TestServiceImpl implements TestService {


    @Async
    @Override
    public void asyncTask() {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3);
            System.out.println("first====================="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：方法1耗时asyncTask：" + (endTime - startTime));
    }

    @Async("asyncTaskExecutor")
    @Override
    public Future<String> asyncTask(String s) {
        long startTime = System.currentTimeMillis();
        try {
            if ( Thread.currentThread().isInterrupted() ) {
                System.out.println("i has interputed");
            }
            //模拟耗时
            Thread.sleep(30);
            System.out.println("second====================="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("i has InterruptedException");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：方法2耗时second：" + (endTime - startTime));
        return AsyncResult.forValue(s);
    }

    @Async("asyncTaskExecutor")
    @Override
    public void asyncTaskForTransaction() {
        System.out.println("third====================="+Thread.currentThread().getName());
    }
}