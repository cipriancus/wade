package com.wade.cryma.news.endpoint;

import com.wade.cryma.crymamodel.model.News;
import com.wade.cryma.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsEndpoint {

    @Autowired
    INewsService newsService;

    /**
     * /news/ get latest news
     *
     * @param page page no of news
     * @param size how many items per number
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public List<News> getNews(@RequestParam("page") String page, @RequestParam("size") String size) {
        return newsService.getNews(page, size);
    }

    /**
     * /news/coin/{coinId} get news of a coin
     *
     * @param coinId a coin id
     * @param page   page no of news
     * @param size   how many items per number
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/coin/{coinId}", produces = "application/json")
    public List<News> getNewsByCoin(@RequestParam("coinId") String coinId, @RequestParam("page") String page, @RequestParam("size") String size) {
        return newsService.getCoinNewsById(coinId, page, size);
    }

    /**
     * /news/{newsId} get news by id
     *
     * @param newsId a coin id
     * @return list of news
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{newsId}", produces = "application/json")
    public News getNewsById(@RequestParam("newsId") String newsId) {
        return newsService.getNewsById(newsId);
    }
}
