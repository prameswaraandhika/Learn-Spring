package com.springdasar.loosecoupling;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springdasar.loosecoupling")
public class DemoApplicationSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoApplicationSpringBeans.class)) {
            System.out.println("Run using GameConsole");
            context.getBean(GamingConsole.class).startGame();
            System.out.println("Run using GameRunner");
            context.getBean(GameRunner.class).run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
