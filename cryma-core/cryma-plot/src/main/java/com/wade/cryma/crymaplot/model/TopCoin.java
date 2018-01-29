package com.wade.cryma.crymaplot.model;

import javax.persistence.*;

@Entity
@Table(name = "TopCoin")
public class TopCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "NAME")
    public String name;

    @Column(name = "MARKET_CAP")
    public float marketCap;

    @Column(name = "PRICE")
    public float price;

    @Column(name = "SUPPLY")
    public float supply;

    @Column(name = "VOLUME")
    public float volume;

    @Column(name = "CHANGEVALUE")
    public float change;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(float marketCap) {
        this.marketCap = marketCap;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSupply() {
        return supply;
    }

    public void setSupply(float supply) {
        this.supply = supply;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
