package com.springdasar.example02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            System.out.println("RESULT: " + context.getBean(BusinessCalculationService.class).findMax());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
