package com.wade.cryma.news.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    @NotNull
    private String description;

    //The most common ISO DateTime Format yyyy-MM-dd'T'hh:mm:ss.SSSZ e.g. 2000-10-31 01:30:00.000-05:00. The default if no annotation value is specified.
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private Date date;

    @Column(name = "URL")
    private String url;

    @ElementCollection
    List<Long> aboutCoinId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Long> getAboutCoinId() {
        return aboutCoinId;
    }

    public void setAboutCoinId(List<Long> aboutCoinId) {
        this.aboutCoinId = aboutCoinId;
    }
}
