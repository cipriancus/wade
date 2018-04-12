package com.wade.cryma.crymaplot.repository.gatherdata;

import com.wade.cryma.crymaplot.model.restmodel.CoinMarketCap;
import com.wade.cryma.crymaplot.model.Coin;
import com.wade.cryma.crymaplot.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CoinMarketCapRepository {

    private String coinMarketCapUrl = "https://api.coinmarketcap.com/v1/ticker/?limit=";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CoinRepository coinRepository;

    public List<Coin> getAllCoins(Long limit) {
        String localUrl = coinMarketCapUrl + limit;
        List<Coin> list = new ArrayList<>();

        try {
            CoinMarketCap[] coinMarketCaps = restTemplate.getForObject(localUrl, CoinMarketCap[].class);

            for (CoinMarketCap iterator : coinMarketCaps) {
                Coin coin = new Coin();

                List<Coin> existingCoin = coinRepository.findByName(iterator.getName());

                if (existingCoin.size() > 0) {
                    coin.setId(existingCoin.get(0).getId());
                }

                if (iterator.getName() != null) {
                    coin.setName(iterator.getName());

                    if (iterator.getMarket_cap_usd() != null)
                        coin.setMarketCap(iterator.getMarket_cap_usd());

                    if (iterator.getPrice_usd() != null)
                        coin.setPrice(iterator.getPrice_usd());

                    if (iterator.getAvailable_supply() != null)
                        coin.setSupply(iterator.getAvailable_supply());

                    if (iterator.getVolume_usd() != null)
                        coin.setVolume(iterator.getVolume_usd());

                    if (iterator.getPercent_change_24h() != null)
                        coin.setChange(iterator.getPercent_change_24h());

                    if (iterator.getSymbol() != null)
                        coin.setAbbreviation(iterator.getSymbol());
                }
                list.add(coin);
            }
        } catch (Exception e) {
            return list;
        }
        return list;
    }
}
