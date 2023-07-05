package com.autowiredAndImport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class A {
    // autowiring member variables is considered bad but just to
    // illustrate the point
    @Autowired
    public B bRef;


    public A() {}

    public void sayHi() {
        bRef.sayHi();
    }
   @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        bRef.sayHi();
        // bRef was constructed and injected into our component
    }


}