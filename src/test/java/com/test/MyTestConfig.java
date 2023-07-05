package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuhaisheng
 * @date 2023/1/30 0030
 * @dec 描述
 */

@Configuration
public class MyTestConfig {


    @Bean
    public Driver driver() {
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }


}
