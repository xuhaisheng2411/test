package com.rpc;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/13 0013 17:55
 * @Version: 1.0  服务实现：
 */
public class HelloServiceImpl  implements HelloService  {
    @Override
    public String hello(String name) {

        return "hello " + name;
    }
}
