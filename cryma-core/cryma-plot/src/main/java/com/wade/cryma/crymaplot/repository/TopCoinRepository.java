package com.wade.cryma.crymaplot.repository;

import com.wade.cryma.crymaplot.model.TopCoin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "coin", path = "coin")
public interface TopCoinRepository extends CrudRepository<TopCoin,Long> {
    Page<TopCoin> findAll(Pageable page);
}
