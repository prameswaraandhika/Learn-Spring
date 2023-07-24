package com.springdasar.autowiring.example02;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Specializaitons of component
 * Streotype Annotation
 * @Service indicates that an annotated class has busineslogic
 * @Controller indicates that an annotated class is a Controller
 * @Repository indicates that an annotated class is used for manipulate data in database
 * @Component if its none of these, using this
 * 
 * Why using a Spesific Annotation
 * You're giving more information about what a specific class is going to do.
 * You can use AOP or aspect oriented programming at a later point to detect the annotation and add additional behavior on top of it.
 * 
 */
@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("RESULT : " + context.getBean(BusinessCalculationService.class).findMax());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
