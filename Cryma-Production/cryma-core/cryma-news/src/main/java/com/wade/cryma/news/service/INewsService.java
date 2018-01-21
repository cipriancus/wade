package com.wade.cryma.news.service;

import com.wade.cryma.news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INewsService {
    List<News> getNews(String Page, String size);
    List<News> getCoinNewsById(String coinId, String startDate, String endDate);
    News getNewsById(String newsId);
}
