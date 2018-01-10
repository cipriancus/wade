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
    public long marketCap;

    @Column(name = "PRICE")
    public long price;

    @Column(name = "SUPPLY")
    public long supply;

    @Column(name = "VOLUME")
    public long volume;
    
    @Column(name = "CHANGE")
    public long change;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getSupply() {
        return supply;
    }

    public void setSupply(long supply) {
        this.supply = supply;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getChange() {
        return change;
    }

    public void setChange(long change) {
        this.change = change;
    }

}
