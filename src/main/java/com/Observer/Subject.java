package com.Observer;


import java.util.Vector;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 14:48
 * @Version: 1.0
 */
public class Subject {
    //观察者数组
    private Vector<Observer> oVector = new Vector<>();

    //增加一个观察者，相当于观察者注册
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }

    //通知所有观察者，主题有变化时通知观察者
    public void notifyObserver() {
        for(Observer observer : this.oVector) {
            observer.response();
        }
    }


}
