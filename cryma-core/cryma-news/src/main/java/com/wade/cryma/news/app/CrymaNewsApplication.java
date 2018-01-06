package com.wade.cryma.news.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class CrymaNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrymaNewsApplication.class, args);
	}
}
