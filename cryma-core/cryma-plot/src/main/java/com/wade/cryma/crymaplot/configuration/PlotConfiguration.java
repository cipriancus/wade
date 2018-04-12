package com.wade.cryma.crymaplot.configuration;

import com.wade.cryma.crymaplot.repository.gatherdata.CoinApiRepository;
import com.wade.cryma.crymaplot.repository.gatherdata.CoinMarketCapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PlotConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CoinMarketCapRepository coinMarketCapRepository() {
        return new CoinMarketCapRepository();
    }

    @Bean
    public CoinApiRepository coinApiRepository(){
        return new CoinApiRepository();
    }
}
