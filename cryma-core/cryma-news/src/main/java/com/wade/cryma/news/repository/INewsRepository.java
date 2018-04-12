package com.wade.cryma.news.repository;

import com.wade.cryma.news.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.domain.Pageable;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "news",path = "news")
public interface INewsRepository extends CrudRepository<News,Long> {
    Page<News> findAll(Pageable page);

    @Override
    <S extends News> S save(S entity);
}