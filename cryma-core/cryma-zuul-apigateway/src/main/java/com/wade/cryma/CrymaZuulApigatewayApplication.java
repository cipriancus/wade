package com.wade.cryma;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


//@EnableZuulProxy
@SpringBootApplication
public class CrymaZuulApigatewayApplication {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(CrymaZuulApigatewayApplication.class, args);

		/*
		 * // Object[] sources = {SpringCloudZuulExampleApplication.class, new
		 * UrlResource(new URL("file:C:/dev/abc_dynamic.groovy"))}; Object[] sources =
		 * {SpringCloudZuulExampleApplication.class, new
		 * ClassPathResource("groovy/ExampleSurgicalDebugFilterBean.groovy")};
		 * SpringApplication.run(sources, args);
		 */
	}
}
