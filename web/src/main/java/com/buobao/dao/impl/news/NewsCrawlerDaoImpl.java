package com.buobao.dao.impl.news;

import com.buobao.dao.impl.BaseDaoImpl;
import com.buobao.dao.news.NewsCrawlerDao;
import com.buobao.entity.news.NewsCrawler;
import org.springframework.stereotype.Repository;

/**
 * Created by dqf on 2015/7/16.
 */
@Repository
public class NewsCrawlerDaoImpl extends BaseDaoImpl<NewsCrawler, String> implements NewsCrawlerDao {
}
