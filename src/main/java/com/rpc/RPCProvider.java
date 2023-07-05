package com.rpc;

import java.io.IOException;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/13 0013 17:56
 * @Version: 1.0 服务器端服务启动
 */
public class RPCProvider {
    public static void main(String args[]) throws IOException {
        HelloService service = new HelloServiceImpl();
        RPCFramework.export(service, 1234);
    }
}
