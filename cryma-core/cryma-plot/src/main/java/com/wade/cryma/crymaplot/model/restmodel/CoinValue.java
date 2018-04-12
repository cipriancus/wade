package com.wade.cryma.crymaplot.model.restmodel;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class CoinValue {
    @JsonProperty("time")
    Date time;

    @JsonProperty("asset_id_quote")
    String asset_id_quote;

    @JsonProperty("rate")
    Double rate;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAsset_id_quote() {
        return asset_id_quote;
    }

    public void setAsset_id_quote(String asset_id_quote) {
        this.asset_id_quote = asset_id_quote;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
};
