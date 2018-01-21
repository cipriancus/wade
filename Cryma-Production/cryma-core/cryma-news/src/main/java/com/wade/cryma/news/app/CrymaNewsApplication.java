package com.wade.cryma.news.app;

import com.wade.cryma.news.repository.impl.NewsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.wade.cryma.news.*")
public class CrymaNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrymaNewsApplication.class, args);
    }
}
