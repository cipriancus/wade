package com.wade.cryma.news.service;

import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cryma-plot")
public interface IPlotService {

    @RequestMapping(method = RequestMethod.GET, path = "/coin/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    String getCoin(@PathVariable("id") String id);
}
