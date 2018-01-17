package com.wade.cryma.news.service.impl;

import com.wade.cryma.crymamodel.model.News;
import com.wade.cryma.news.repository.INewsRepository;
import com.wade.cryma.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsService implements INewsService {

    @Autowired
    INewsRepository newsRepository;

    @Override
    public List<News> getNews(String page, String size) {
        return newsRepository.getNews(page,size);
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
