package com.AsyncThreadpool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//执行异步多线程
public class AsyncMain {
    public static void main(String[] args) {
        /*方法一*/
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JobRunExecutorConfig.class);
        ctx.refresh();

        /*方法二*/
        ApplicationContext context = new AnnotationConfigApplicationContext(JobRunExecutorConfig.class);
        //AsyncTaskService ent = (AsyncTaskService)context.getBean("AsyncTaskService");//错误写法
        AsyncTaskService ent = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 5; i++) {
            ent.executeAsyncTask1();
            ent.executeAsyncTask2();
        }
        System.out.println("====================================");



        //@Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        /*如果加载spring-context.xml文件：
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        */


    }
}
