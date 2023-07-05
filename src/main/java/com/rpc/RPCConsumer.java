package com.rpc;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/13 0013 17:56
 * @Version: 1.0 客户端服务代理
 */
public class RPCConsumer {
    public static void main(String args[]) throws InterruptedException{
        HelloService service = RPCFramework.refer(HelloService.class, "192.168.11.4", 1234);
      //  for(int i = 0; i < Integer.MAX_VALUE; i++){
        for(int i = 0; i < 10; i++){
            String hello = service.hello("world" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }

    }
}
