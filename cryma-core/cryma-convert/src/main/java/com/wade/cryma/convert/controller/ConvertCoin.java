package com.wade.cryma.convert.controller;

import com.wade.cryma.convert.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertCoin {

    @Autowired
    private ConvertService convertService;

    @RequestMapping(path = "/convert", method = RequestMethod.GET)
    public Double convert(@RequestParam("from") String from,
                          @RequestParam("to") String to) {
        return convertService.convert(from, to);
    }
}
