package com.wade.cryma.news.endpoint;

import com.wade.cryma.news.model.News;
import com.wade.cryma.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsEndpoint {

    @Autowired
    INewsService newsService;

    /**
     * /news/ get latest news
     *
     * @param limit limit article count
     * @param format the sparql output format
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "text/plain")
    public String getNews(@RequestParam(value = "limit", required = false) String   limit, @RequestParam(value = "format", required = false) String format) {
        return newsService.getNews(limit, format);
    }

    /**
     * /news/coin/{abbreviation} get news of a coin
     *
     * @param abbreviation a coin abbreviation
     * @param limit        limit article count
     * @param format the sparql output format
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/coin/{abbreviation}",  produces = "text/plain")
    public String getNewsByCoin(@PathVariable("abbreviation") String abbreviation, @RequestParam(value = "limit", required = false) String limit, @RequestParam(value = "format", required = false) String format) {
        return newsService.getCoinNewsByAbbreviation(abbreviation, limit, format);
    }
}
