package com.volatileTest;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/24 0024 9:19
 * @Version: 1.0  先执行静态，后main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("1");
        new Main();
        // new  Main();

        System.out.println(3/2);

    }

    public Main(){
        System.out.println("2");
    }
    {
        System.out.println("3");
    }
    {
        System.out.println("32");
    }
    static {
        System.out.println("4");
    }
}
