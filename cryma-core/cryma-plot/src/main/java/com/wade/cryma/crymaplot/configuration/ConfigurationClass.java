package com.wade.cryma.crymaplot.configuration;

import com.wade.cryma.crymaplot.interceptor.RequestFilter;
import com.wade.cryma.crymaplot.repository.ICoinRepository;
import com.wade.cryma.crymaplot.repository.impl.CoinRepository;
import com.wade.cryma.crymaplot.service.ICoinService;
import com.wade.cryma.crymaplot.service.impl.CoinService;
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
    public ICoinService coinService() {
        return new CoinService();
    }

    @Bean
    public ICoinRepository coinRepository() {
        return new CoinRepository(fusekiEndpoint);
    }

    @Bean
    public FilterRegistrationBean requestFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        List<String> filterPath = new ArrayList<>();
        filterPath.add("/plot/{abbreviation}");

        filterRegistrationBean.setFilter(new RequestFilter());
        filterRegistrationBean.setUrlPatterns(filterPath);
        return filterRegistrationBean;
    }
}
