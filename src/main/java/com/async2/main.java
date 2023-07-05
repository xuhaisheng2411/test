/*
package com.async2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@SpringBootTest
@Component
@EnableAsync//开启异步调用
@SpringBootApplication
public class main {

    @Autowired
    private TestService TestService;

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
    */
/**
     * 启动成功
     *//*

    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
            //无返回值
            TestService.asyncTask();
            //有返回值，但主线程不需要用到返回值
            Future<String> future = TestService.asyncTask("huanzi-qch");
            //有返回值，且主线程需要用到返回值
            TestService.asyncTaskForTransaction();
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
        };
    }




}*/
