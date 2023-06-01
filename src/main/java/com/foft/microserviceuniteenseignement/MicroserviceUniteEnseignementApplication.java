package com.foft.microserviceuniteenseignement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.foft.microserviceuniteenseignement")
@EnableDiscoveryClient
@RefreshScope
public class MicroserviceUniteEnseignementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUniteEnseignementApplication.class, args);
    }

}
