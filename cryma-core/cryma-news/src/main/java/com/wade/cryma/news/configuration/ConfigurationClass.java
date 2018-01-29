package com.wade.cryma.news.configuration;

import com.wade.cryma.news.interceptor.RequestFilter;
import com.wade.cryma.news.repository.INewsRepository;
import com.wade.cryma.news.repository.impl.NewsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationClass {

    @Value("${fuseki.endpoint}")
    String fusekiEndpoint;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public INewsRepository newsRepository(){
        return new NewsRepository(fusekiEndpoint);
    }

    @Bean
    public FilterRegistrationBean requestFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();

        List<String> filterPath=new ArrayList<>();
        filterPath.add("/news/*");

        filterRegistrationBean.setFilter(new RequestFilter());
        filterRegistrationBean.setUrlPatterns(filterPath);
        return filterRegistrationBean;
    }
}
