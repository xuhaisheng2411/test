package com.StaticProxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 11:08
 * @Version: 1.0
 */
public class ProxyFactory {
    private RealMovie realMovie =new RealMovie();
    public movie CreateProxy()
    {
        /*
         newProxyInstance()方法有三个参数：
         1.类加载器
         2.被代理对象的 接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口接口
         3.InvocationHandler接口的实现类
        */
        /*
        invoke方法的参数：
        1.跟 movie对象是一致
        2.对接口中方法进行封装的method
        3.调用方法的实际参数
        */
        movie movie=(movie) Proxy.newProxyInstance(
                realMovie.getClass().getClassLoader(),
                realMovie.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("执行前！");
                        Object invoke = method.invoke(realMovie, args);
                        System.out.println("执行后！");
                        return invoke;
                    }
                }
        );
        return movie;
    }




}
//客户使用
 class Client2 {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        movie movie = proxyFactory.CreateProxy();
        movie.play();
        movie.play2();
    }
}