package com.async2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
@EnableAsync//开启异步调用
@SpringBootApplication
public class MainTest {

    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {

        /*现在在主线程main*/
        System.out.println("主线程=====================" + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
        testService.asyncTask(); //无返回值
        Future<String> future = testService.asyncTask("xuhaisheng"); //有返回值，但主线程不需要用到返回值
        testService.asyncTaskForTransaction();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));

    }
}
