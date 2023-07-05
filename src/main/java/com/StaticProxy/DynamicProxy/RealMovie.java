package com.StaticProxy.DynamicProxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 11:08
 * @Version: 1.0
 */
public class RealMovie implements movie {
    public void play() {
        System.out.println("正在播放电影.........");
    }
    public void play2() {
        System.out.println("正在播放电影2.........");
    }
}
