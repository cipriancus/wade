package com.wade.cryma.news.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.wade.cryma.news.*")
public class CrymaNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrymaNewsApplication.class, args);
	}
}
