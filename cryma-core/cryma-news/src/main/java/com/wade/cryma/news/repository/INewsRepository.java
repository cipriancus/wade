package com.wade.cryma.news.repository;

import com.wade.cryma.crymamodel.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INewsRepository{
    List<News> getNews(String Page, String size);
}
