package com.buobao.dao;

import com.buobao.bean.Pager;
import com.buobao.entity.MongoEntity;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dqf on 2015/7/14.
 */
public interface MongoBaseDao<T extends MongoEntity, PK extends Serializable> {
    List<T> find(Query var1);

    T findOne(Query var1);

    void update(Query var1, Update var2);

    T save(T var1);

    T findById(String var1);

    T findById(String var1, String var2);

    Pager findPage(Pager var1, Query var2);

    long count(Query var1);
}
