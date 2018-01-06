package com.wade.cryma.conversion.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class CoinConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinConversionApplication.class, args);
	}
}
