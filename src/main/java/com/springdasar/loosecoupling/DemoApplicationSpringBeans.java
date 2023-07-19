package com.springdasar.loosecoupling;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplicationSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            System.out.println("Run using GameConsole");
            context.getBean(GamingConsole.class).startGame();
            System.out.println("Run using GameRunner");
            context.getBean(GameRunner.class).run();
        } catch (BeansException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
