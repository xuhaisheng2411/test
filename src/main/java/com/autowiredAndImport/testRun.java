package com.autowiredAndImport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 启动异步调用
public class testRun {
    private static final Logger log = LoggerFactory.getLogger(testRun.class);

    @Bean
    public void sayHi() {
        System.out.println("Hello World@Bean");
    }

    public static void main(String[] args) {

        SpringApplication.run(testRun.class, args);
        testRun  tt=new testRun();
        tt.sayHi();
    }
}
