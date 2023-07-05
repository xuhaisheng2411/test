package com.StaticProxy;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 11:03
 * @Version: 1.0
 */
//代理类 刘德华代理人
public class Cinema  implements movie{
    private RealMovie realMovie ;
    public void play() {
        start();
        realMovie.play();
        end();
    }

    public Cinema(RealMovie realMovie) {
        this.realMovie = realMovie;
    }

    public void start()
    {
        System.out.println("电影播放开始！");
    }
    public void end()
    {
        System.out.println("电影播放结束！");
    }

}

//客户使用
 class Client {
    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        movie cinema = new Cinema(realMovie);
        cinema.play();
    }

}