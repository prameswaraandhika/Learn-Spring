package com.springdasar.autowiring.example03;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class BusinessService {
    private DataService dataService;

    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}

@Named
class DataService {

    @Override
    public String toString() {
        return "DataService []";
    }

}

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Main.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
            System.out.println("INJECT DENDEPENDCY USING JAKARTA EE");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}