package com.wade.cryma;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CrymaZuulApigatewayApplication {

    public static void main(String[] args) throws MalformedURLException {
        SpringApplication.run(CrymaZuulApigatewayApplication.class, args);
    }

//    @Bean
//    public ZuulGatewayPreFilter gatewayPreFilter() {
//        return new ZuulGatewayPreFilter();
//    }
}
