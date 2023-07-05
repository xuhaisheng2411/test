package com.cglib;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 13:59
 * @Version: 1.0
 */

//被代理类
public class ExecutionTimeReality implements CglibInterface{
    //这里打印出任务名，并休眠500ms模拟任务执行了很长时间
    public void dealTask(String taskName) {
        System.out.println("Task is running: " + taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //这里打印出任务名，并休眠500ms模拟任务执行了很长时间
    public void sayHello(String name) {
        System.out.println("hello: " + name);
    }


}
