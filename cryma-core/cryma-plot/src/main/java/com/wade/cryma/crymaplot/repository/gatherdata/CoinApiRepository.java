package com.wade.cryma.crymaplot.repository.gatherdata;

import com.wade.cryma.crymaplot.model.Coin;
import com.wade.cryma.crymaplot.model.restmodel.CoinApi;
import com.wade.cryma.crymaplot.model.CoinHistory;
import com.wade.cryma.crymaplot.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoinApiRepository {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${coinapi.url}")
    private String baseUrl;

    @Value("${coinapi.key}")
    private String key;

    public List<CoinHistory> updateCoinValues() {

        String localUrl = "";

        List<CoinHistory> allCoinHistory = new ArrayList<>();

        List<String> allCoinAbbreviations = coinRepository.getAllAbbreviations();

        for (String iterator : allCoinAbbreviations) {
            localUrl = baseUrl + iterator + "/USD" + "?apikey=" + key;

            try {
                CoinApi coinApi = restTemplate.getForObject(localUrl, CoinApi.class);

                List<Coin> coinList = coinRepository.findByAbbreviation(iterator);

                if (coinList.isEmpty() == false) {

                    Coin coin = coinList.get(0);
                    CoinHistory coinHistory = new CoinHistory();

                    coinHistory.setTime(new Date());
                    coinHistory.setValue(coinApi.getRate());
                    coinHistory.setCoin(coin);

                    allCoinHistory.add(coinHistory);
                }
            }catch (Exception exception){
                return allCoinHistory;
            }
        }
        return allCoinHistory;
    }
}
