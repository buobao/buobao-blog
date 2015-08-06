package com.buobao.entity.manager;

import com.buobao.bean.BaseEnum.MsgStateEnum;
import com.buobao.entity.Entity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by dqf on 2015/7/16.
 */
@javax.persistence.Entity
@Table(name = "blog_contact")
public class Contact extends Entity {
    private static final long serialVersionUID = -370316274269471216L;

    public Contact(){}

    public Contact(String email){
        if (StringUtils.isNotEmpty(email) && StringUtils.isNotBlank(email)){
            this.email = email;
            this.name = email.split("@")[0];
        }
    }

    public Contact(String email, String name){
        this(email);
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotBlank(name) && name.trim()!=""){
            this.name = name;
        }
    }

    private String email;
    private String name;
    private String Phone;
    private String message;
    private MsgStateEnum state;

    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(nullable = false)
    public MsgStateEnum getState() {
        return state;
    }

    public void setState(MsgStateEnum state) {
        this.state = state;
    }
}
