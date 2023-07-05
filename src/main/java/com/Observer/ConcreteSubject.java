package com.Observer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 14:49
 * @Version: 1.0
 */
public class ConcreteSubject extends Subject {
    //具体业务
    public void doSomething() {
        //...

        System.out.println("具体目标发生改变...");
        System.out.println("------业务处理中--------");
        super.notifyObserver();

    }

}
