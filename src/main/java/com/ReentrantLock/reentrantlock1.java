package com.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/27 0027 11:14
 * @Version: 1.0
 */
public class reentrantlock1 {
    public static void main(String[] args) {

        Ticket1 ticket =new Ticket1();
        new Thread(()->{for (int i=1;i<60;i++)ticket.sellTicket();},"A").start();
        new Thread(()->{for (int i=1;i<60;i++)ticket.sellTicket();},"B").start();
        new Thread(()->{ for (int i=1;i<60;i++) ticket.sellTicket(); },"C").start();

    }


}

class  Ticket1 {
    private int ticket=50;
    private int leftTicket=1;
    Lock lock = new ReentrantLock();
    public void sellTicket() {
        lock.lock();
        try {
            if (ticket>0)
            {
                ticket--;
                leftTicket++;
                System.out.println(Thread.currentThread()+"卖出了第"+(leftTicket)+"张票"+"剩下:"+ticket+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
