package com.wade.cryma.crymaplot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COINS_HISTORY")
public class CoinHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "TIME")
    //The most common ISO DateTime Format yyyy-MM-dd'T'hh:mm:ss.SSSZ e.g. 2000-10-31 01:30:00.000-05:00. The default if no annotation value is specified.
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    private Date time;

    @Column(name="COINS_ID")
    public Long coinsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getTime() {
        return new Date();
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getCoinId() {
        return coinsId;
    }

    public void setCoinId(Long coinId) {
        this.coinsId = coinId;
    }
}
