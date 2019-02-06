package com.wade.cryma.news.controller;

import com.wade.cryma.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    INewsService newsService;

    @RequestMapping(path = "/news/create", method = RequestMethod.POST)
    public ResponseEntity createNews(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description,
                                     @RequestParam(name = "date") String date,
                                     @RequestParam(name = "url") String url,
                                     @RequestParam(name = "aboutCoin") List<Long> aboutCoin
    ) {
        try {
            boolean response = newsService.createNews(name, description, new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").parse(date), url, aboutCoin);
            if(response==true){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request, check coin availability");
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data in invalid format yyyy-MM-dd'T'hh:mm:ss");
        }
    }
}

