package com.buobao.action.com;

import com.buobao.action.BaseAction;
import com.buobao.bean.Pager;
import com.buobao.entity.news.NewsCrawler;
import com.buobao.service.news.NewsCrawlerService;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dqf on 2015/7/14.
 */
@ParentPackage("com")
public class IndexAction extends BaseAction {
    @Resource
    NewsCrawlerService newsCrawlerService;
    private List<NewsCrawler> newsCrawlerList;

    public String execute(){
        pager = new Pager(10);
        newsCrawlerList = (List<NewsCrawler>) newsCrawlerService.findByPager(pager).getList();
        return SUCCESS;
    }

    public List<NewsCrawler> getNewsCrawlerList() {
        return newsCrawlerList;
    }

    public void setNewsCrawlerList(List<NewsCrawler> newsCrawlerList) {
        this.newsCrawlerList = newsCrawlerList;
    }
}
