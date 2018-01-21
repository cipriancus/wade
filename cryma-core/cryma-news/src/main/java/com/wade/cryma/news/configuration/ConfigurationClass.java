package com.wade.cryma.news.configuration;

import com.wade.cryma.news.repository.INewsRepository;
import com.wade.cryma.news.repository.impl.NewsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationClass {

    @Value("${news.owl}")
    String newsOWLUri;

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
        return new NewsRepository(newsOWLUri);
    }
}
