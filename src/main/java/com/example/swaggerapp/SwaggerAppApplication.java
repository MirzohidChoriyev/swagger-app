package com.example.swaggerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SwaggerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerAppApplication.class, args);
    }

}
