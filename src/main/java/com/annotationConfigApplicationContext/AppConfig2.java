package com.annotationConfigApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean(name = "entitlement4")
    public Entitlement entitlement(){

        Entitlement ent = new Entitlement();
        ent.setName("Entitlement");
        ent.setTime(20);

        return ent;
    }
}
