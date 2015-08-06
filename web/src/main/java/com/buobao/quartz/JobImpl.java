package com.buobao.quartz;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.buobao.bean.BaseEnum;
import com.buobao.entity.news.NewsCrawler;
import com.buobao.entity.news.Website;
import com.buobao.service.news.NewsCrawlerService;
import com.buobao.service.news.WebsiteService;
import com.buobao.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by dqf on 2015/7/16.
 */

public class JobImpl extends BreadthCrawler implements Job {
    @Resource
    private WebsiteService websiteService;
    @Resource
    private NewsCrawlerService newsCrawlerService;
    private List<String> urls_regex;

    public void init(){
        //清除数据
        newsCrawlerService.clear();
        urls_regex = new ArrayList();
        List<Website> websiteList = websiteService.getAll();
        if (websiteList != null && websiteList.size() > 0){
            for (Website wbs:websiteList){
                this.addSeed(wbs.getUrl());
                this.addRegex("^"+wbs.getUrl()+"[\\w\\W]*");
                this.urls_regex.add("^"+wbs.getUrl()+"[\\w\\W]*");
            }
        }
        this.addRegex("-.*\\.(jpg|png|gif).*");
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page){
        for (String regex:this.urls_regex){
            if (Pattern.matches(regex, page.getUrl())){
                String title=page.getDoc().select("h1[id=artibodyTitle]").text();
                String body=page.getDoc().select("div[id=artibody] p").text();
                String date = page.getDoc().select("span[id=pub_date]").text();
                Date publish_date = DateUtil.TurnsinaDate(date);
                if (StringUtils.isNotEmpty(body) && publish_date != null) {
                    NewsCrawler newsCrawler = new NewsCrawler();
                    newsCrawler.setN_body(body);
                    newsCrawler.setN_from("sina");
                    newsCrawler.setN_publicDate(publish_date);
                    newsCrawler.setN_title(title);
                    if (title.length() > 30){
                        newsCrawler.setN_sub_title(title.substring(0,30)+"...");
                    } else{
                        newsCrawler.setN_sub_title(title);
                    }
                    newsCrawler.setState(BaseEnum.NewsStateEnum.USING);
                    newsCrawlerService.save(newsCrawler);
                }
            }
        }
    }

    @Override
    public void getNewsfromSites() throws Exception {
        System.out.println("search...");
        this.init();
        this.start(2);
    }
}
