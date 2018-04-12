package com.wade.cryma.crymaplot.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CRON_EXECUTION")
public class CronExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "UPDATE_COINS")
    public Integer updateCoins = 0;//state 0 unused, 1 active, 2 finished

    @Column(name = "UPDATE_COINS_HISTORY")
    public Integer updateCoinsHistory = 0;

    @Column(name = "START_TIME")
    public Long startTime = Instant.now().getEpochSecond();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUpdateCoins() {
        return updateCoins;
    }

    public void setUpdateCoins(Integer updateCoins) {
        this.updateCoins = updateCoins;
    }

    public Integer getUpdateCoinsHistory() {
        return updateCoinsHistory;
    }

    public void setUpdateCoinsHistory(Integer updateCoinsHistory) {
        this.updateCoinsHistory = updateCoinsHistory;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
