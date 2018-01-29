package com.wade.cryma.news.service;

import com.wade.cryma.news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INewsService {
    String getNews(String limit, String format);

    String getCoinNewsByAbbreviation(String abbreviation, String limit, String format);
}
