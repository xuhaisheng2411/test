package com.AsyncThreadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async("jobRunPoolExecutor")
    @Bean("executeAsyncTask1")
    public void executeAsyncTask1() {

        System.out.println(Thread.currentThread().getName() + "执行异步任务1" );

    }

    @Async("jobRunPoolExecutor")
    @Bean("executeAsyncTask2")
    public void executeAsyncTask2() {

        System.out.println(Thread.currentThread().getName() + "执行异步任务2" );

    }

}

