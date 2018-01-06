package com.wade.cryma.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class CrymaCointologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrymaCointologyApplication.class, args);
	}
}
