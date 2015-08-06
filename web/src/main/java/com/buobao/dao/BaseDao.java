package com.buobao.dao;

import com.buobao.bean.BaseEnum;
import com.buobao.bean.Pager;
import com.buobao.entity.Entity;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/7/14.
 */
public interface BaseDao<T extends Entity, PK extends Serializable> {
    Object getObject(String var1, PK var2);
    /*单个ID查询*/
    T get(PK var);

    T load(PK var);
    /*ID数组查询*/
    List<T> get(PK[] var);

    /*前面是属性名，后面是属性值*/
    T get(String var1, Object var2);

    List<T> getList(String var1, Object var2);
    /*查询所有*/
    List<T> getAll();

    Query getQuery(String var1);

    Object getUniqueResult(String var1);

    Object getUniqueResult(String var1, Map<String, Object> var2);
    /*查数量*/
    Long getTotalCount();
    /*是否唯一*/
    boolean isUnique(String var1, Object var2, Object var3);
    /*是否已存在*/
    boolean isExist(String var1, Object var2);
    /*保存*/
    PK save(T var1);
    /*更新*/
    void update(T var1);
    /*删除 按值*/
    void delete(T var1);
    /*删除 按ID*/
    void delete(PK var1);
    /*删除 ID数组*/
    void delete(PK[] var1);
    /*刷新*/
    void flush();
    /*清除*/
    void clear();

    void evict(Object var1);
    /*分页查询*/
    Pager findByPager(Pager var1);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, Date var5, Date var6, Map<String, Object> var7);

    List<T> getList(DetachedCriteria var1, List<String> var2, String var3, Date var4, Date var5, Map<String, Object> var6, String var7, BaseEnum.OrderType var8);

    List<T> getAll(String var1);

    List<T> getList(String var1, Map<String, Object> var2);

    List<Map<String, Object>> getMapedList(String var1, Map<String, Object> var2);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, String var5, String var6, String var7);

    Pager findByPager(Pager var1, DetachedCriteria var2);

    Pager findByPager(Pager var1, DetachedCriteria var2, List<String> var3, String var4, Date var5, Date var6, Map<String, Object> var7, String var8, BaseEnum.OrderType var9);
}
