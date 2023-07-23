package com.springdasar.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * LAZY
 * Adalah tindakan untuk menunda Pembuatan Bean di Spring
 * Penundaan terjadi hingga Bean itu dipanggil atau diperlukan
 * May be used on any class directly or indirectly annotated @Component or on methods annotated with @Bean.
 */
@Component
class Whiskas {

    @Override
    public String toString() {
        return "Makanan Basah Anak Kucing Whiskas Pouch Junior Ikan Kembung";
    }

}

@Component
@Lazy
class Cat {
    Whiskas whiskas;

    public Cat(Whiskas whiskas) {
        System.out.println("Cat received!");
        this.whiskas = whiskas;
    }

    void eat() {
        System.out.println("Kucing makan " + whiskas);
    }

}

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            System.out.println("Give some pouch Whiskas to Cat!");
            // context.getBean(Cat.class).eat();
        }
    }
}
