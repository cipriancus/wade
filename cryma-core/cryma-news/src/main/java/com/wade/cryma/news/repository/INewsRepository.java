package com.wade.cryma.news.repository;

import com.wade.cryma.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INewsRepository {
    String getNews(String limit, String format);

    String getCoinNewsByAbbreviation(String abbreviation, String limit, String format);
}
