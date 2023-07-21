package com.springdasar.example01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * InnerMain
 */

@Component
class BusinesClass {
    DenpendencieA denpendencieA;
    DenpendencieB denpendencieB;

    // @Autowired // constructor injection for dependencies of bussiness logic object
    public BusinesClass(DenpendencieA denpendencieA, DenpendencieB denpendencieB) {
        this.denpendencieA = denpendencieA;
        this.denpendencieB = denpendencieB;
    }

    @Override
    public String toString() {
        return "Using " + denpendencieA + ", " + denpendencieB;
    }
}

@Component
class DenpendencieA {

}

@Component
class DenpendencieB {

}

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) throws Exception {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinesClass.class));
        }
    }
}
