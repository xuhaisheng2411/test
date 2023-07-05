package com.futureAndThread;

public class RealData   {
    protected final String result;
    public RealData(String para) {
       // System.out.println(Thread.currentThread().getName() + "Thread.currentThread().getName()RealData" );
         try {
             System.out.println("RealData......RealData处理业务开始");
             Thread.sleep(20000);
            System.out.println("RealData......RealData处理业务完成。等待20秒结束over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer sb=new StringBuffer();
        //假设这里很慢很慢，构造RealData不是一个容易的事
        sb.append("i was realdata");
        sb.append(para);
        result =sb.toString();
    }

}