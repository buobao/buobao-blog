package com.buobao.entity.news;

import com.buobao.bean.BaseEnum.NewsStateEnum;
import com.buobao.entity.Entity;

import javax.persistence.Column;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by dqf on 2015/7/17.
 */
@javax.persistence.Entity
@Table(name="news_basketball_news")
public class NewsCrawler extends Entity {
    private static final long serialVersionUID = -370316274269471216L;

    public NewsCrawler(){}

    private String n_title;
    private String n_sub_title;
    private String n_body;
    private Date n_publicDate;
    private String n_from;
    private NewsStateEnum state;

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    @Column(length = 65536)
    public String getN_body() {
        return n_body;
    }

    public void setN_body(String n_body) {
        this.n_body = n_body;
    }

    @OrderBy("name desc")
    public Date getN_publicDate() {
        return n_publicDate;
    }

    public void setN_publicDate(Date n_publicDate) {
        this.n_publicDate = n_publicDate;
    }

    public String getN_from() {
        return n_from;
    }

    public void setN_from(String n_from) {
        this.n_from = n_from;
    }

    public NewsStateEnum getState() {
        return state;
    }

    public void setState(NewsStateEnum state) {
        this.state = state;
    }

    public String getN_sub_title() {
        return n_sub_title;
    }

    public void setN_sub_title(String n_sub_title) {
        this.n_sub_title = n_sub_title;
    }
}
