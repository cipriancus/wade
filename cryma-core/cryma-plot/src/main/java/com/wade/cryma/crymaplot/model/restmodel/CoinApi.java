package com.wade.cryma.crymaplot.model.restmodel;

import org.codehaus.jackson.annotate.JsonProperty;

public class CoinApi {

    @JsonProperty("rate")
    Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
