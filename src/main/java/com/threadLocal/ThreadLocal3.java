package com.threadLocal;

public class ThreadLocal3 {
    private static ThreadLocal<Integer> content = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return (int)(Math.random()*10+100);
        }
    };
    private static ThreadLocal<String> test = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "单例模式是不安全的"+(int)(Math.random()*10+100);
        }
    };

    public static void main(String[] args) {
            //多次调用查看
            System.out.println(content.get());
            System.out.println(test.get());
            System.out.println();


    }


}
