package com.wade.cryma.convert.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cryma-plot")
public interface PlotService {
    @RequestMapping(method = RequestMethod.GET, path = "/coin/search/getValueByAbbreviation?abbreviation={coin}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Double getValueByAbbreviation(@PathVariable("coin") String abbreviation);
}
