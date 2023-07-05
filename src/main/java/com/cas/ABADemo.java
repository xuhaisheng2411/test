package com.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/13 0013 11:21
 * @Version: 1.0
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference =new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        System.out.println("=================以下会产生ABA问题=================");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();
        new Thread(()->{
            try{TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();  }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t" +atomicReference.get());
        },"t2").start();

        try{ TimeUnit.SECONDS.sleep(3); }catch (Exception e){e.printStackTrace();  }
        System.out.println("================以下是ABA问题解决==================");
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);
            //暂停1秒t3线程
            try{
                TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();  }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第2次版本号："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第3次版本号："+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);
            //暂停3秒t4线程,保证上面的t3线程完成了一次ABA操作
            try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();  }
            boolean result = atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t 修改成功否："+result+"\t 当前最新实际版本号 ："+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值："+atomicStampedReference.getReference());
        },"t4").start();
    }


}
