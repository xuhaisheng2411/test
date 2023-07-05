package com.AsyncThreadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ComponentScan("com.AsyncThreadpool")
@EnableAsync
public class JobRunExecutorConfig {
	@Bean("jobRunPoolExecutor")
	public ThreadPoolTaskExecutor jobRunPoolExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 核心线程数（默认线程数）
		executor.setCorePoolSize(800);
		// 最大线程数
		executor.setMaxPoolSize(2000);
		// 缓冲队列数
		executor.setQueueCapacity(1000);
		// 允许线程空闲时间（单位：默认为秒）
		executor.setKeepAliveSeconds(10);
		// 线程名称的前缀
		executor.setThreadNamePrefix("jobrun-");
		// 线程池对拒绝任务的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化
		executor.initialize();
		return executor;
	}
}
