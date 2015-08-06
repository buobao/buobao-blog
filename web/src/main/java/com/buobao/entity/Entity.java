package com.buobao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dqf on 2015/7/13.
 */
@MappedSuperclass
public class Entity implements Serializable{
    private static final long serialVersionUID = -2755329278196422649L;
    protected String id;
    protected Date createDate;
    protected Date modifyDate;
    protected String timestamp;
    //protected Integer version;

    public Entity(){}

    @Id
    @Column(
            length = 32,
            nullable = false
    )
    @GeneratedValue(
            generator = "uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Column(
            updatable = false
    )
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(
            nullable = false,
            unique = true
    )
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int hashCode(){
        return this.id == null?System.identityHashCode(this):this.id.hashCode();
    }

    /*
    //乐观锁
    @Version
    @Column(name="OPTLOCK")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    */
}
