package com.AsyncThreadpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/20 0020 10:22
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class mainPool {

    @Resource
    public JobRunExecutorConfig podService;



    @Test
    public    void contextLoads() {

        try {
            ThreadPoolTaskExecutor threadPoolTaskExecutor = null;
            threadPoolTaskExecutor = podService.jobRunPoolExecutor();

            Future fature= threadPoolTaskExecutor.submit(()->{

                System.out.println("111111111111111111111");
                int a=10/0;
                System.out.println("222222222222222222222");
            });

            /*

            threadPoolTaskExecutor.execute(()->{

                System.out.println("111111111111111111111");
                int a=10/0;
                System.out.println("222222222222222222222");
            });
            */

            Object o=fature.get();
            System.out.println("444"+o);
            threadPoolTaskExecutor.shutdown();
        } catch (InterruptedException e) {
            System.out.println("错误11111111111");
        } catch (ExecutionException e) {
            System.out.println("错误111112111111");
        }

    }



}
