package com.springdasar.autowiring;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
         * ApplicationContext is the core of Spring, because their managed all Bean that
         * means Its Container
         * For use an ApplicationContext we must add @Configuration
         * Configure the things that we want Spring to manage - @Configuration
         */
        try (var context = new AnnotationConfigApplicationContext(ConfigManager.class)) {
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));

            System.out.println("personThird");
            System.out.println(context.getBean("personThirdParam"));
            System.out.println(context.getBean("adress1"));

            // If any 2 Beans who returning same Object using this way.it will getting an
            // error
            // if we not set @Primary for the bean who can prioritize
            System.out.println(context.getBean(Adress.class));

            // Call Beans who use Qualifier param
            System.out.println(context.getBean("personUseQualifier"));

            // List all Beans in context
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        } catch (BeansException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
