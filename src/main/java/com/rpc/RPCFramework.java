package com.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/13 0013 17:54
 * @Version: 1.0
 */
public class RPCFramework {
    /**暴露  服务
     *
     * @param service
     * @param port
     * @throws IOException
     */
    public static void export(final Object service, int port) throws IOException {
        if(service == null)
            throw new IllegalArgumentException("service instance == null");
        if(port <= 0 || port > 65535)
            throw new IllegalArgumentException("invard port" + port);
        System.out.println("Export service " + service.getClass().getName() + "on port" + port);

        @SuppressWarnings("resource")
        ServerSocket server = new ServerSocket(port);

        for(;;){
            try{
                final Socket socket =  server.accept();
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try{
                            try{

                                ObjectInputStream input = new ObjectInputStream(
                                        socket.getInputStream());
                                try{
                                    String methodName = input.readUTF();
                                    //method parameter type
                                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                                    //method parameter
                                    Object[] arguments = (Object[])input.readObject();
                                    ObjectOutputStream output = new ObjectOutputStream
                                            (socket.getOutputStream());
                                    try{
                                        Method method = service.getClass().getMethod
                                                (methodName, parameterTypes);
                                        Object result = method.invoke(service, arguments);
                                        output.writeObject(result);
                                    }catch(Throwable t){
                                        output.writeObject(t);
                                    }finally{
                                        output.close();
                                    }
                                }finally{
                                    input.close();
                                }
                            }finally{
                                socket.close();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     *
     * @param interfaceClass 接口类型
     * @param host 主机名
     * @param port 端口号
     * @return 远程服务
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port){
        if(interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if(! interfaceClass.isInterface())
            throw new IllegalArgumentException
                    ("The " + interfaceClass.getName() + " must be interface class ");
        if(host == null || host.length() == 0)
            throw new IllegalArgumentException("host == null");
        if(port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Get remote service " + interfaceClass.getName() +
                " from service " + host + ":" + port);

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}
                , new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Socket socket = new Socket(host,port);
                        try{
                            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                            try{
                                output.writeUTF(method.getName());
                                output.writeObject(method.getParameterTypes());
                                output.writeObject(args);
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                                try{
                                    Object result = input.readObject();
                                    if(result instanceof Throwable)
                                        throw (Throwable)result;
                                    return result;
                                }finally{
                                    input.close();
                                }
                            }finally{
                                output.close();
                            }
                        }finally{
                            socket.close();
                        }

                    }
                });
    }
}
