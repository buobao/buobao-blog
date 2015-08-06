package com.buobao.entity.manager;


import com.buobao.bean.BaseEnum.AccountEnum;
import com.buobao.bean.BaseEnum.AccountState;
import com.buobao.entity.Entity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by dqf on 2015/7/16.
 */
@javax.persistence.Entity
@Table(name="blog_user")
public class User extends Entity{
    private final static long serialVersionUID = -370316274269471216L;

    public User(){}

    public User(String email){
        super();
        if(StringUtils.isNotEmpty(email) && StringUtils.isNotBlank(email) && email.trim() != ""){
            this.name = email.split("@")[0];
            this.email = email;
        }
        this.psw = "pass";
    }

    public User(String email, String name){
        this(email);
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotBlank(name) && name.trim() != "") {
            this.name = name;
        }
    }

    /*名称*/
    private String name;
    /*邮箱*/
    private String email;
    /*密码*/
    private String psw;
    /*幸运数字*/
    private String luck_number;
    /*注册地址*/
    private String location;
    /*生日*/
    private String birthday;
    /*备注*/
    private String remark;
    /*一句话*/
    private String words;
    /*上次登录时间*/
    private String last_login;
    /*状态*/
    private AccountState accountState;
    /*账号类别*/
    private AccountEnum accountType;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getLuck_number() {
        return luck_number;
    }

    public void setLuck_number(String luck_number) {
        this.luck_number = luck_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public AccountEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountEnum accountType) {
        this.accountType = accountType;
    }
}
