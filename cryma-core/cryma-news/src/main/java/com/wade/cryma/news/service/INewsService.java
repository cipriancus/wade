package com.wade.cryma.news.service;

import com.wade.cryma.news.model.News;
import com.wade.cryma.news.repository.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface INewsService {

    public boolean createNews(String name, String description,
                       Date date, String url,
                       List<Long> aboutCoin);
}