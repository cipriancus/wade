package com.wade.cryma.crymapythonprediction.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LibraryRequest {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${library.url}")
    private String url;

    public Map<String,List<String>> sendLibraryRequest(String coinId) {
        try {
            //url = url + coinId;
            Map<String,List<String>> predictionList = restTemplate.getForObject(url, Map.class);
            return predictionList;
        }catch (Exception e){
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
