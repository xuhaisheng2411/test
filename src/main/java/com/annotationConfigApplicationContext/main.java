package com.annotationConfigApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);

        Entitlement ent = (Entitlement)ctx.getBean("entitlement");

        System.out.println(ent.getName());
        System.out.println(ent.getTime());

        System.out.println("-----------------------------------------------------------");

        AppConfig2 appConfig = ctx.getBean(AppConfig2.class);
        Entitlement entitlement = appConfig.entitlement();
        System.out.println(entitlement.getName());
        System.out.println(entitlement.getTime());

    }


}
