package com.StaticProxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 11:02
 * @Version: 1.0
 */
//被代理类 刘德华
public class RealMovie implements movie{
    public void play() {
        System.out.println("正在播放电影.........");
    }
}
