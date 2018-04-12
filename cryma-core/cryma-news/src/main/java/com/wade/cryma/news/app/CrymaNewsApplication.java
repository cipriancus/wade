package com.wade.cryma.news.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.wade.cryma.news.*")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.wade.cryma.news.repository")
@EntityScan(basePackages = "com.wade.cryma.news.model")
@ComponentScan("com.wade.cryma.news.*")
public class CrymaNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrymaNewsApplication.class, args);
    }
}
