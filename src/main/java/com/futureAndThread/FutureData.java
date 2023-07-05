package com.futureAndThread;

public class FutureData implements DataInterface {

    /**
      * @Author Administrator
      * @Desctription TODO
      * @Date 2022/4/19 0019 11:43
      * @Param  代理类,作为realdata的代理
      * @return
      */
    // 内部需要维护RealData
    protected RealData realdata = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realdata) {
        //System.out.println(Thread.currentThread().getName() + "Thread.currentThread().getName()   FutureData" );
        if (isReady) {
            return;
        }
        this.realdata = realdata;
        isReady = true;
        notifyAll();
        System.out.println("Future...............代理notifyAll，getResult，"+isReady);
    }
    //会等待RealData构造完成`
    public synchronized String getResult() {
        System.out.println("Future...............进入getResult"+isReady);
        while (!isReady) {
            try {
                System.out.println("Future...............一直等待，直到RealData处理完成，wait等待开始");
                wait();
                System.out.println("Future...............一直等待，直到RealData处理完成，wait等待结束");
            } catch (InterruptedException e) {
            }
        }
        return realdata.result;
    }
}