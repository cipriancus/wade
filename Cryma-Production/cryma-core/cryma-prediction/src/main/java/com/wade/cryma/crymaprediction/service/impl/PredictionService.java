package com.wade.cryma.crymaprediction.service.impl;

import com.wade.cryma.crymaprediction.service.IPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PredictionService implements IPredictionService {
    @Autowired
    private RestTemplate restTemplate;

    private String predictionURL = "http://cryma-python-prediction/predict/";

    @Override
    public Map<String, List<String>> predict(String coinId, String startDate, String endDate) {

        predictionURL = append(predictionURL, coinId, startDate, endDate);

        try {
            Map<String, List<String>> returnMap = restTemplate.getForObject(predictionURL, Map.class);
            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private String append(String url, String coinId, String startDate, String endDate) {
        url = url + coinId + "?startDate=" + startDate + "&endDate=" + endDate;
        return url;
    }
}
