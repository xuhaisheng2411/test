package com.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 14:00
 * @Version: 1.0
 */
public class DynamicProxyFactory {
    public static Object getInstance() {
        Object target = new ExecutionTimeReality();
        ExecutionTimeProxy proxySubject = new ExecutionTimeProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(proxySubject);
        return enhancer.create();
    }

}

 class Demo2 {
    public static void main(String[] args) {
        //System.setProperty设置指定键对值的系统属性。相当于一个静态变量  ，存在内存里面！
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\CglibProxyClass");
        // ExecutionTimeReality subject = (ExecutionTimeReality) DynamicProxyFactory.getInstance();

        Object target = new ExecutionTimeReality();
        ExecutionTimeProxy proxySubject = new ExecutionTimeProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(proxySubject);
        ExecutionTimeReality subject = (ExecutionTimeReality) enhancer.create();
        subject.dealTask("TestTask");
        subject.sayHello("lisi");

        System.setProperty("name", "张三");
        System.setProperty("age", "28");
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("age"));
    }
}