package com.wade.cryma.convert.configuration;

import com.wade.cryma.convert.service.ConvertService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConvertConfiguration {
    @Bean
    public ConvertService convertService() {
        return new ConvertService();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
