package com.finance;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.finance")
public class FinanceSpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FinanceSpringApplication.class, args);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(name -> name.contains("Controller"))
                .forEach(System.out::println);
    }
}