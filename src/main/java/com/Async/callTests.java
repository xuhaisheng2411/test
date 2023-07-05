package com.Async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ThreadPool.class)
public class callTests {

    @Autowired
    private service service;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        service.asyncInvokeSimplest();
        service.asyncInvokeWithParameter("test");
        Future<String> future = service.asyncInvokeReturnFuture(99);
        System.out.println(future.get());
    }
}
