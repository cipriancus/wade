package com.wade.cryma.crymapythonprediction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.wade.cryma.crymapythonprediction.*")
public class CrymaPythonPredictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrymaPythonPredictionApplication.class, args);
	}
}
