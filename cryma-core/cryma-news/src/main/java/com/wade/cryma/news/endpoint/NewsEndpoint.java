package com.wade.cryma.news.endpoint;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsEndpoint {

    /**
     * /news/
     * @param page page no of news
     * @param itemNo how many items per number
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public Map<String, List<String>> getLatest(@RequestParam("page") String page, @RequestParam("itemNo") String itemNo)  {
        throw new NotImplementedException();
    }

    /**
     * /coin/{coinId}
     * @param coinId a coin id
     * @param page page no of news
     * @param itemNo how many items per number
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/coin/{coinId}", produces = "application/json")
    public Map<String, List<String>> getNewsByCoin(@RequestParam("coinId") String coinId, @RequestParam("page") String page, @RequestParam("itemNo") String itemNo) {
        throw new NotImplementedException();
    }
}
