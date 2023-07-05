package com.StaticProxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 12:10
 * @Version: 1.0
 */
//调用代理对象类
public class ProxyFactory2 implements InvocationHandler {
    private movie movie;

    public void setRealMovie(movie movie) {
        this.movie = movie;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前！");
        Object invoke = method.invoke(movie, args);
        System.out.println("执行后！");
        return invoke;
    }

}
//客户调用，还是第一种好用
 class Client3 {
    public static void main(String[] args) {


        movie movie =new RealMovie();
        ProxyFactory2 proxyFactory2 = new ProxyFactory2();
        proxyFactory2.setRealMovie(movie);
        movie ProxyMovie =(movie) Proxy.newProxyInstance(
                movie.getClass().getClassLoader(),
                movie.getClass().getInterfaces(),
                proxyFactory2
        );
        ProxyMovie.play();
        ProxyMovie.play2();
    }
}
