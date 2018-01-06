package com.wade.cryma;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinInfo {

    @JsonProperty("id")
    public String id; // string

    @JsonProperty("name")
    public String name; // string

    @JsonProperty("symbol")
    public String symbol; // string

    @JsonProperty("rank")
    public String rank; // integer

    @JsonProperty("price_usd")
    public String price_usd; // float

    @JsonProperty("price_btc")
    public String price_btc; // float

    @JsonProperty("24_volume_usd")
    public String h24_volume_usd; // float

    @JsonProperty("market_cap_usd")
    public String market_cap_usd; // float

    @JsonProperty("available_supply")
    public String available_supply; // float

    @JsonProperty("total_supply")
    public String total_supply; // float

    @JsonProperty("max_supply")
    public String max_supply; // float

    @JsonProperty("percent_change_1h")
    public String percent_change_1h; // float

    @JsonProperty("percent_change_24h")
    public String percent_change_24h; // float

    @JsonProperty("percent_change_7d")
    public String percent_change_7d; // float

    @JsonProperty("last_updated")
    public String last_updated; // integer
}
