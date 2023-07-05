package com.Observer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 14:52
 * @Version: 1.0
 */
public class ObserverMain {
    public static void main(String[] args) {
        //创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserverImp();
        Observer observer2 = new ConcreteObserverImp2();
        //注册观察者
        subject.addObserver(observer);
        subject.addObserver(observer2);
        //开始活动
        subject.doSomething();
    }


}
