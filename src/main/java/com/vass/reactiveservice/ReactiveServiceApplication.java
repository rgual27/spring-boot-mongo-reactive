package com.vass.reactiveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.vass.reactiveservice", "com.vass.reactiveservice.mapper"})
public class ReactiveServiceApplication {

   public static void main(String[] args) {
        SpringApplication.run(ReactiveServiceApplication.class, args);
    }

}
