package com.springdasar.post_pre_constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * If we want make an Method perform automatic called as Soon as Denpendency autowired
 * We can use @PostCostruct below method, it will be automaticly Executed after do autowired
 * 
 * If we want to Disconnected 
 */
@Component
class Whiskas {
    public void getDetail() {
        System.out.println("Makanan Basah Anak Kucing Whiskas Pouch Junior Ikan Kembung");
    }
}

@Component
class Cat {
    Whiskas whiskas;

    public Cat(Whiskas whiskas) {
        this.whiskas = whiskas;
        System.out.println("Cat received");
    }

    @PostConstruct
    public void detailWhiskas() {
        whiskas.getDetail();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up whiskaz.");
    }
}

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            // context.getBean(Cat.class).eat();
        }
    }
}
