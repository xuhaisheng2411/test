package com.jdkProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/17 0017 11:11
 * @Version: 1.0
 */
public class LoggerProxy {
    private Object oject;

    public LoggerProxy(Object oject) {
        this.oject = oject;
    }

    /**
     * 生成代理对象，不用实现接口，代理方法只需写一次，新增被代理类可复用
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(oject.getClass().getClassLoader(), oject.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("执行前打印日志");
                        Object returnValue = method.invoke(oject, args);
                        System.out.println("执行后打印日志");
                        return returnValue;
                    }
                });
    }
}
