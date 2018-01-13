package com.wade.cryma.crymaplot.service.impl;

import com.wade.cryma.crymamodel.model.Coin;
import com.wade.cryma.crymaplot.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoinService implements ICoinService {

    @Autowired
    private RestTemplate restTemplate;

    String url = "http://cryma-cointology/";

    @Override
    public List<Coin> getCoinValues(String coinId, String startDate, String endDate) {
        String requestUrl = url + coinId + "?startDate=" + startDate + "&endDate=" + endDate;

        try {
            List<Coin> returnList = restTemplate.getForObject(requestUrl, List.class);
            return returnList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
