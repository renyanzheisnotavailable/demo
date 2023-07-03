package com.example.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Demo7Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo7Application.class, args);
    }

}
