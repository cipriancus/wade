package com.wade.cryma.crymaplot.model.restmodel;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CoinApi {

    @JsonProperty("asset_id_base")
    String asset_id_base;

    @JsonProperty("rates")
    List<CoinValue> rates;

    public String getAsset_id_base() {
        return asset_id_base;
    }

    public void setAsset_id_base(String asset_id_base) {
        this.asset_id_base = asset_id_base;
    }

    public List<CoinValue> getRates() {
        return rates;
    }

    public void setRates(List<CoinValue> rates) {
        this.rates = rates;
    }
}
