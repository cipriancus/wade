package com.wade.cryma.crymaplot.repository;

import com.wade.cryma.crymaplot.model.CronExecution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CronExecutionRepository extends CrudRepository<CronExecution, Long> {

    @Query("from CronExecution c where c.updateCoins=1 or c.updateCoins=2 order by c.id desc")
    List<CronExecution> getLastUpdateCoins();

    @Query("from CronExecution c where c.updateCoinsHistory=1 or c.updateCoinsHistory=2 order by c.id desc")
    List<CronExecution> getLastUpdateCoinsHistory();
}
