package com.buobao.service.impl.news;

import com.buobao.dao.BaseDao;
import com.buobao.dao.news.WebsiteDao;
import com.buobao.entity.news.Website;
import com.buobao.service.impl.BaseServiceImpl;
import com.buobao.service.news.WebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dqf on 2015/7/16.
 */
@Service
public class WebsiteServiceImpl extends BaseServiceImpl<Website, String> implements WebsiteService {
    @Resource
    WebsiteDao websiteDao;

    @Override
    public BaseDao<Website, String> getBaseDao() {
        return websiteDao;
    }
}
