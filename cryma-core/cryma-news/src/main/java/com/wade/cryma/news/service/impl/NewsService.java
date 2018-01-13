package com.wade.cryma.news.service.impl;

import com.wade.cryma.crymamodel.model.News;
import com.wade.cryma.news.service.INewsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsService implements INewsService {
    @Override
    public List<News> getNews(String Page, String size) {
        return null;
    }

    @Override
    public List<News> getCoinNewsById(String coinId, String startDate, String endDate) {
        return null;
    }

    @Override
    public News getNewsById(String newsId) {
        return null;
    }
}
