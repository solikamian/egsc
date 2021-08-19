package com.cgsc.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EgscApplication {


    public static void main(String[] args) {
        SpringApplication.run(EgscApplication.class, args);
    }

}
