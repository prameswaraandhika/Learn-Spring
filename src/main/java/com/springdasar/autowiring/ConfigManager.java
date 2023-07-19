package com.springdasar.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Adress adress) {
};

record Adress(String city, String country) {
};

@Configuration
public class ConfigManager {

    @Bean
    String name() {
        return "Ronaldo";
    }

    @Bean
    int age() {
        return 23;
    }

    @Bean
    Person person() {
        return new Person("Andhika", 23, adress1());
    }

    @Bean(name = "adress1")
    @Primary
    Adress adress1() {
        return new Adress("Jakarta", "Indonesia");
    }

    @Bean(name = "adress2")
    Adress adress2() {
        return new Adress("Bekasi", "Indonesia");
    }

    @Bean(name = "adress3")
    @Qualifier("addres3Qualifier")
    Adress adress3() {
        return new Adress("Kalimantan", "Indonesia");
    }

    @Bean(name = "personThirdParam")
    Person personWithParams(String name, int age, Adress adress2) {
        return new Person(name, age, adress2);
    }

    @Bean()
    Person personUseQualifier(String name, int age, @Qualifier("addres3Qualifier") Adress adress2) {
        return new Person(name, age, adress2);
    }

}
