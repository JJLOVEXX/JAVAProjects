package com.jackfrued.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        // TWR (Java 7+)
        try (ConfigurableApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Person person = factory.getBean(Person.class);
            System.out.println(person);
            Car car=factory.getBean(Car.class);
            System.out.println(car);
        }
    }
}
