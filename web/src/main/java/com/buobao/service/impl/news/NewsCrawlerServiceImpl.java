package com.buobao.service.impl.news;

import com.buobao.dao.BaseDao;
import com.buobao.dao.news.NewsCrawlerDao;
import com.buobao.entity.news.NewsCrawler;
import com.buobao.service.impl.BaseServiceImpl;
import com.buobao.service.news.NewsCrawlerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dqf on 2015/7/16.
 */
@Service
public class NewsCrawlerServiceImpl extends BaseServiceImpl<NewsCrawler, String> implements NewsCrawlerService{
    @Resource
    NewsCrawlerDao newsCrawlerDao;

    @Override
    public BaseDao<NewsCrawler, String> getBaseDao() {
        return newsCrawlerDao;
    }
}
