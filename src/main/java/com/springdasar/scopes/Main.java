package com.springdasar.scopes;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Basicly every Beans is singleton
 * If you want a diferent instance to be created each time a Bean
 * We can use Scope Prototype
 * Just Add scope value is equal to prototype, and this would ensure that each time you ask the spring framework
 * 
 */
@Component
class Cat {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class CatPrototype {

}

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) throws Exception {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {

            System.out.println(context.getBean(Cat.class));
            System.out.println(context.getBean(Cat.class));
            System.out.println(context.getBean(Cat.class));

            System.out.println(context.getBean(CatPrototype.class));
            System.out.println(context.getBean(CatPrototype.class));
            System.out.println(context.getBean(CatPrototype.class));

        }
    }
}
