package com.wade.cryma.convert.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.wade.cryma.convert.*")
@ComponentScan("com.wade.cryma.convert.*")
public class CrymaConvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrymaConvertApplication.class, args);
    }
}
