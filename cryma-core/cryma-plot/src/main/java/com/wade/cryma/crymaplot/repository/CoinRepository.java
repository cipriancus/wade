package com.wade.cryma.crymaplot.repository;

import com.wade.cryma.crymaplot.model.Coin;
import com.wade.cryma.crymaplot.model.CoinHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "coin", path = "coin")
public interface CoinRepository extends CrudRepository<Coin, Long> {
    Page<Coin> findAll(Pageable page);

    List<Coin> findByName(String name);

    List<Coin> findByAbbreviation(@Param("abbreviation") String abbreviation);

    @Query("select c.price from Coin c where c.abbreviation=:abbreviation")
    Double getValueByAbbreviation(@Param("abbreviation") String abbreviation);

    @Query("select t.abbreviation from Coin t")
    List<String> getAllAbbreviations();

    @Override
    <S extends Coin> S save(S entity);
}
