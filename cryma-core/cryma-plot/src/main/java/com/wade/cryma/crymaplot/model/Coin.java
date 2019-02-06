package com.wade.cryma.crymaplot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @Column(name="COIN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "NAME")
    public String name;

    @Column(name = "MARKET_CAP")
    public Double marketCap;

    @Column(name = "PRICE")
    public Double price;

    @Column(name = "SUPPLY")
    public Double supply;

    @Column(name = "VOLUME")
    public Double volume;

    @Column(name = "CHANGEVALUE")
    public Double change;

    @Column(name = "ABBREVIATION")
    public String abbreviation;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="coin")
    public List<CoinHistory> coinHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSupply() {
        return supply;
    }

    public void setSupply(Double supply) {
        this.supply = supply;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CoinHistory> getCoinHistory() {
        return coinHistory;
    }

    public void setCoinHistory(List<CoinHistory> coinHistory) {
        this.coinHistory = coinHistory;
    }
}
