package com.jdkProxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/17 0017 11:07
 * @Version: 1.0
 */
public class Student implements Person {
    public String say(String message) {
        return "hello " + message;
    }
}
