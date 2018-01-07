package com.wade.cryma.crymaprediction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(value = "com.wade.cryma.crymaprediction.*")
public class CrymaPredictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrymaPredictionApplication.class, args);
	}
}
