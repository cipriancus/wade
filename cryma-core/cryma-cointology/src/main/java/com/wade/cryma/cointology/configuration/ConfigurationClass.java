package com.wade.cryma.cointology.configuration;

import com.wade.cryma.cointology.repository.ICointologyRepository;
import com.wade.cryma.cointology.repository.impl.CointologyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigurationClass {

    @Value("${fuseki.endpoint}")
    String fusekiEndpoint;


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ICointologyRepository coinService() {
        return new CointologyRepository(fusekiEndpoint);
    }

}
