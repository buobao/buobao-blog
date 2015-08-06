package com.buobao.service.impl;

import com.buobao.dao.MongoBaseDao;
import com.buobao.entity.MongoEntity;
import com.buobao.service.MongoBaseService;
import com.buobao.service.common.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by dqf on 2015/7/15.
 */
@Service
public abstract class MongoBaseServiceImpl<T extends MongoEntity, PK extends Serializable> implements MongoBaseService<T,PK>{
    private MongoBaseDao<T,PK> mongoBaseDao;
    @Resource
    protected ResultService resultService;
}










































