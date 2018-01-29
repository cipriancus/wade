package com.wade.cryma.news.service.impl;

import com.wade.cryma.news.model.News;
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
    public String getNews(String limit, String format) {
        return newsRepository.getNews(limit, format);
    }

    @Override
    public String getCoinNewsByAbbreviation(String coinId, String limit, String format) {
        return newsRepository.getCoinNewsByAbbreviation(coinId, limit, format);
    }
}
