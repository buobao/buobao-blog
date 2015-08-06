package com.buobao.entity.news;

import com.buobao.entity.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by dqf on 2015/7/16.
 */
@javax.persistence.Entity
@Table(name="news_website")
public class Website extends Entity {
    private static final long serialVersionUID = -370316274269471218L;

    public Website(){}

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
