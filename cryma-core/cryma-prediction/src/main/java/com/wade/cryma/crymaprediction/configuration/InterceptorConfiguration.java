package com.wade.cryma.crymaprediction.configuration;

import com.wade.cryma.crymaprediction.interceptor.PredictionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PredictionInterceptor()).addPathPatterns("/predict/{coinId}");
    }
}
