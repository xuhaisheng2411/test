package com.autowiredAndImport;

import org.springframework.stereotype.Component;

@Component
public class B {
    public B() {}

    public void sayHi() {
        System.out.println("Hello World333");
    }
}