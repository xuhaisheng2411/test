package com.jdkProxy2;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/17 0017 14:54
 * @Version: 1.0
 */
public class mian {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderService proxy = (OrderService) new LoggerProxy(orderService).getProxyInstance();
        proxy.saveOrder();
        proxy.selectOrder();
    }

}
