package com.wade.cryma.crymapythonprediction.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LibraryRequest {
    @Autowired
    private RestTemplate restTemplate;

    private String url;

    @Autowired
    public LibraryRequest(@Value("#{systemProperties['library.url']}") String url){
        this.url=url;
    }

    public List<Integer> sendLibraryRequest(String coinId){
        List<Integer> predictionList=restTemplate.getForObject(url,List.class);
        return predictionList;
    }
}
