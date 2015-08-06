import com.buobao.bean.Email;
import com.buobao.bean.NewsCheck;
import com.buobao.service.common.SimpleMailService;
import com.buobao.service.news.NewsCrawlerService;
import com.buobao.service.news.WebsiteService;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import test.SpringTransactionalTestCase;

import javax.annotation.Resource;

/**
 * Created by dqf on 2015/7/16.
 */
@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class NewsCrawlerTest extends SpringTransactionalTestCase {
    @Resource
    public WebsiteService websiteService;
    @Resource
    NewsCheck newscheck;
    @Resource
    NewsCrawlerService newsCrawlerService;
    @Resource
    SimpleMailService simpleMailService;

    @Test
    public void getNewsTest() throws Exception {
        //NewsCheck newsCrawler = new NewsCheck(websiteService.getAll());
        //newsCrawler.start(2);
    }

    @Test
    public void getWebsites() throws Exception {
        //List<Website> websiteList = websiteService.getAll();
        //System.out.println(websiteList.get(0).getName()+","+websiteList.get(0).getUrl());
        //NewsCheck newsCheck = new NewsCheck();
        newscheck.init();
        newscheck.start(2);
    }

    @Test
    public void clearTest() {
        newsCrawlerService.clear();
        System.out.println("clear");
    }

    @Test
    public void sendMailTest(){
        simpleMailService.sendNotificationMail("lebron_king_james@163.com","000000");
        Email email = new Email();
        email.setAccount("lebron_king_james@163.com");
        email.setSubject("Hello");
        email.setBody("This is a test mail,if you received this mail,it means this mail service is available!");
        simpleMailService.send(email);
    }
}






















