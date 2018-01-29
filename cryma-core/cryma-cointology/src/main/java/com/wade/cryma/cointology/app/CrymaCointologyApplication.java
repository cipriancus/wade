package com.wade.cryma.cointology.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.wade.cryma.cointology.*")
public class CrymaCointologyApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CrymaCointologyApplication.class, args);
	}
}
