package com.jackfrued.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        return new Car("Benz", 320);
    }

    @Bean
    public Person person() {
        return new Person("Jackson", 19);
    }
}
