/*
package com.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

*/
/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/11/16 0016 15:51
 * @Version: 1.0
 *//*

@Async(value = "asyncOrderRespTaskExecutor")
//注解来声明一个或多个异步任务，可以加在方法或者类上，加在类上表示这整个类都是使用这个自定义线程池进行操作
@Configuration
@EnableAsync
@Slf4j
public class threadPoolConfig {
    */
/**
     * Set the ThreadPoolExecutor's core pool size.
     *//*

    private int corePoolSize = 300;
    */
/**
     * Set the ThreadPoolExecutor's maximum pool size.
     *//*

    private int maxPoolSize = 300;

    private String ThreadNamePrefix = "OrderResp-Async-Executor-";

    @Bean
    public Executor asyncOrderRespTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setThreadNamePrefix(ThreadNamePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (executor != null) {
                    executor.shutdown();
                }
            } catch (Exception ex) {
                log.error("AsyncTaskConfig.executor.shutdown() error", ex);
                try {
                    executor.shutdown();
                } catch (Exception e) {
                    log.error("AsyncTaskConfig.executor.shutdownNow() error", e);
                }
            }
        }));

        return executor;
    }
}
*/
