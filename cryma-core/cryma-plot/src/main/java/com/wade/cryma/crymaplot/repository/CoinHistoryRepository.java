package com.wade.cryma.crymaplot.repository;

import com.wade.cryma.crymaplot.model.CoinHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "history", path = "history")
public interface CoinHistoryRepository extends CrudRepository<CoinHistory,Long> {
    Page<CoinHistory> findAll(Pageable page);

    @Override
    <S extends CoinHistory> S save(S entity);
}