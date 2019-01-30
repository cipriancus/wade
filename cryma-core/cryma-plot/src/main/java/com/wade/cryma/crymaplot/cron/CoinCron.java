package com.wade.cryma.crymaplot.cron;

import com.wade.cryma.crymaplot.model.CoinHistory;
import com.wade.cryma.crymaplot.model.Coin;
import com.wade.cryma.crymaplot.model.CronExecution;
import com.wade.cryma.crymaplot.repository.CronExecutionRepository;
import com.wade.cryma.crymaplot.repository.gatherdata.CoinApiRepository;
import com.wade.cryma.crymaplot.repository.CoinHistoryRepository;
import com.wade.cryma.crymaplot.repository.gatherdata.CoinMarketCapRepository;
import com.wade.cryma.crymaplot.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.List;

@Component
public class CoinCron {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private CoinHistoryRepository coinHistoryRepository;

    @Autowired
    private CoinMarketCapRepository coinMarketCapRepository;

    @Autowired
    private CoinApiRepository coinApiRepository;

    @Autowired
    private CronExecutionRepository cronExecutionRepository;

    private Long limit = 100L;

    @Scheduled(cron = "*/30 * * * * *")//*/30 * * * * *    */30 * * * * *"
    public void updateCoins() {

        List<CronExecution> list = cronExecutionRepository.getLastUpdateCoins();

        CronExecution execution = null;
        if (list != null && list.size() != 0) {
            execution = list.get(0);
        }

        if (execution == null || execution.getUpdateCoins() == 2 ||
                (execution.getUpdateCoins() == 1 && (Instant.now().getEpochSecond() - execution.getStartTime()) > 3600)) {

            CronExecution newCron = new CronExecution();
            newCron.setUpdateCoins(1);
            newCron = cronExecutionRepository.save(newCron);

            List<Coin> coins = coinMarketCapRepository.getAllCoins(limit);

            coinRepository.save(coins);

            newCron.setUpdateCoins(2);
            cronExecutionRepository.save(newCron);
        }
    }


    @Scheduled(cron = "*/30 * * * * *")//* * 0 * * *
    public void updateCoinsHistory() {

        List<CronExecution> list = cronExecutionRepository.getLastUpdateCoinsHistory();

        CronExecution execution = null;
        if (list != null && list.size() != 0) {
            execution = list.get(0);
        }

        if (execution == null || execution.getUpdateCoinsHistory() == 2 ||
                (execution.getUpdateCoinsHistory() == 1 && (Instant.now().getEpochSecond() - execution.getStartTime()) > 3600)) {

            CronExecution newCron = new CronExecution();
            newCron.setUpdateCoinsHistory(1);
            newCron = cronExecutionRepository.save(newCron);

            List<CoinHistory> coinHistory = coinApiRepository.updateCoinValues();

            coinHistoryRepository.save(coinHistory);

            newCron.setUpdateCoinsHistory(2);
            cronExecutionRepository.save(newCron);
        }
    }
}