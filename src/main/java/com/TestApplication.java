package com;

import com.AsyncThreadpool.JobRunExecutorConfig;
import com.apaas.common.util.PaasCommon;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com"})
@EntityScan(basePackages={"com"})
/*@ComponentScan(basePackages={"com"})*/
@EnableCaching
@EnableRedisHttpSession
@EnableFeignClients
@PaasCommon
public class TestApplication {

	public static void main(String args[]) {
		SpringApplication.run(TestApplication.class, args);
	}



}

  