package com.buobao.service;

import com.buobao.bean.BaseEnum.OrderType;
import com.buobao.bean.Pager;
import com.buobao.entity.Entity;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/7/13.
 */

public interface BaseService<T extends Entity,PK extends Serializable> {
    Object getObject(String var1, PK var2);

    T get(PK var1);

    T load(PK var1);

    List<T> get(PK[] var1);

    T get(String var1, Object var2);

    List<T> getList(String var1, Object var2);

    List<T> getAll();

    Query getQuery(String var1);

    Object getUniqueResult(String var1);

    Long getTotalCount();

    boolean isUnique(String var1, Object var2, Object var3);

    boolean isExist(String var1, Object var2);

    PK save(T var1);

    void update(T var1);

    void delete(T var1);

    void delete(PK var1);

    void delete(PK[] var1);

    void flush();

    void clear();

    void evict(Object var1);

    Pager findByPager(Pager var1);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, Date var5, Date var6, Map<String, Object> var7);

    Pager findByPager(Pager var1, String var2, Date var3, Date var4, Map<String, Object> var5);

    Pager findByPager(Pager var1, Map<String, Object> var2);

    List<T> getList(DetachedCriteria var1, List<String> var2, String var3, Date var4, Date var5, Map<String, Object> var6, String var7, OrderType var8);

    List<T> getList(String var1, Date var2, Date var3, Map<String, Object> var4, String var5, OrderType var6);

    List<T> getList(Map<String, Object> var1, String var2, OrderType var3);

    List<T> getList(Map<String, Object> var1);

    List<T> getAll(String var1);

    List<T> getList(String var1, Map<String, Object> var2);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, String var5, String var6, String var7);

    Pager findByPager(Pager var1, String var2, String var3, String var4, String var5);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, Date var5, Date var6, Map<String, Object> var7, String var8, OrderType var9);

    Pager findByPager(Pager var1, Map<String, Object> var2, String var3, OrderType var4);

    Pager findByPager(Pager var1, String var2, Date var3, Date var4, Map<String, Object> var5, String var6, OrderType var7);
}
