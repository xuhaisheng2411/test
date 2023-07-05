package com.join;
/**
 * @Author: Administrator
 * @Desctription:  join方法：将该线程加入当前线程，当前线程  等待加入线程执行完成  才继续执行
 * @Date: Created in 2022/4/19 0019 17:02
 * @Version: 1.0
 */
public class ThreadJoinTest implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadJoinTest());
        thread.start();
        thread.join(2000); //thread线程插队2秒，造成main线程阻塞2秒
        System.out.println("主线程结束");
    }

    @Override
    public void run() {
        System.out.println("子线程开始");
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("子线程结束");
    }

}
