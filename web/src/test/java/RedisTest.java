import com.buobao.utils.LogUtil;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import redis.clients.jedis.Jedis;
import test.SpringTransactionalTestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dqf on 2015/8/6.
 */
@TransactionConfiguration(defaultRollback=true)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class RedisTest extends SpringTransactionalTestCase {

    //包括基本数据类型和操作方式
    @Test
    public void saveTest(){
        //连接redis服务
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //密码验证，没有密码可以不验证
        //jedis.auth("pass");

        //简单的key-value存储
        jedis.set("redis","buobao's redis");
        LogUtil.info(jedis.get("redis"));
        jedis.append("redis"," append");
        LogUtil.info(jedis.get("redis"));
        jedis.append("new","new append");
        LogUtil.info(jedis.get("new"));

        jedis.del("redis");
        LogUtil.info(jedis.get("redis"));

        jedis.mset("name1","Jack","name2","Marry","name3","Tom");
        LogUtil.info(jedis.get("name1"));
        LogUtil.info(jedis.get("name2"));
        LogUtil.info(jedis.get("name3"));

        Map<String,String> user = new HashMap<>();
        user.put("name","James");
        user.put("password","pass");
        user.put("age","23");
        jedis.hmset("user",user);
        LogUtil.info(String.format("len:%d",jedis.hlen("user")));
        LogUtil.info(String.format("keys:%s",jedis.hkeys("user")));
        LogUtil.info(String.format("values:%s",jedis.hvals("user")));

        LogUtil.info(jedis.hmget("user","name"));    //可以指定读取map中的元素
        LogUtil.info(jedis.hmget("user","name","password"));
        jedis.hdel("user","password");  //删除指定字段
        LogUtil.info(jedis.hmget("user","name","password"));

        //list操作
        jedis.lpush("mylist","A");
        jedis.lpush("mylist","B");
        jedis.lpush("mylist","C");
        jedis.lpush("mylist","D");
        jedis.lpush("mylist","E");
        jedis.lpush("mylist","F");
        LogUtil.info(jedis.lrange("mylist",0,2));        //可以看出list是一个栈的形式，先进后出
        LogUtil.info(jedis.lrange("mylist",0,5));        //输出顺序是F,E,D,C,B,A
        LogUtil.info(jedis.lrange("mylist",0,-1));       //输出F, E, D, C, B, A

        jedis.lpop("mylist");
        LogUtil.info(jedis.lrange("mylist",0,5));
        jedis.del("mylist");

        //set操作
        jedis.sadd("alluser","James");
        jedis.sadd("alluser","Pig");
        jedis.sadd("alluser","dog");
        jedis.sadd("alluser","Jack");
        LogUtil.info(String.format("set num:%d", jedis.scard("alluser")));
        LogUtil.info(String.format("all member:%s", jedis.smembers("alluser")));
        LogUtil.info(String.format("is member:%s", jedis.sismember("alluser", "James")));
        LogUtil.info(String.format("is member:%s", jedis.sismember("alluser", "Tom")));
        LogUtil.info(String.format("rand member:%s",jedis.srandmember("alluser")));       //随机取一个
        jedis.srem("alluser","James");
        LogUtil.info(String.format("all member:%s",jedis.smembers("alluser")));
        jedis.del("alluser");
    }
}
