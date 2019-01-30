package com.wade.cryma.news.service.impl;

import com.wade.cryma.news.model.News;
import com.wade.cryma.news.repository.INewsRepository;
import com.wade.cryma.news.service.INewsService;
import com.wade.cryma.news.service.IPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class NewsService implements INewsService {

    @Autowired
    IPlotService plotService;

    @Autowired
    INewsRepository newsRepository;

    public boolean createNews(String name, String description,
                       Date date, String url,
                       List<Long> aboutCoin) {

        if (name == null || name.isEmpty() ||
                description == null || description.isEmpty()) {
            return false;
        }

        /**
         * Validate that about coin ids exist
         * with a request to the microservice
         **/
        for (Long iterator : aboutCoin) {
            //validate all coins
            if (plotService.getCoin(iterator.toString()).isEmpty()==true) {
                return false;
            }
        }

        News news = new News();
        news.setName(name);
        news.setDescription(description);
        news.setDate(date);
        news.setUrl(url);
        news.setAboutCoinId(aboutCoin);
        newsRepository.save(news);

        return true;
    }
}