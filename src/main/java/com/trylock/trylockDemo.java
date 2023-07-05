package com.trylock;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/27 0027 9:58
 * @Version: 1.0
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class trylockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        MyThread2 myThread2 = new MyThread2(lock);
        MyThread2 myThread = new MyThread2(lock);
        myThread2.start();
        myThread.start();
    }
}
class MyThread2 extends Thread{
    private final Lock  lock ;

    public MyThread2(Lock lock) {
        this.lock=lock;
        super.setName("MyThread2");
    }
    @Override
    public void run () {
        try {
            lock.tryLock(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //lock.lock();
        System.out.println("执行了方法");
    }


}
