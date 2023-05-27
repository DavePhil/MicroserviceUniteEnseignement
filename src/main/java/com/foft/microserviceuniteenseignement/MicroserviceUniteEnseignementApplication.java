package com.foft.microserviceuniteenseignement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.foft.microserviceuniteenseignement")
public class MicroserviceUniteEnseignementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUniteEnseignementApplication.class, args);
    }

}
