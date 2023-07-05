package com.test;

public interface TestInterface {
    /**
     * 异步调用，无返回值
     */
    void asyncTask();


    static void print(){

    }


    default  void test(){

    }

/*    java 9
    private void ppp( String dd){

    };*/
}