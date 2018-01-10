package com.wade.cryma.crymaplot.repository;

import com.wade.cryma.crymaplot.model.TopCoin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "coins", path = "coins")
public interface TopCoinRepository extends CrudRepository<TopCoin,Long> {
    Page<TopCoin> findAll(Pageable page);
}
