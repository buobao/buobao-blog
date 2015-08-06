package com.buobao.service.impl.manager;

import com.buobao.bean.BaseEnum.AccountState;
import com.buobao.bean.Pager;
import com.buobao.dao.BaseDao;
import com.buobao.dao.manager.UserDao;
import com.buobao.entity.manager.User;
import com.buobao.service.impl.BaseServiceImpl;
import com.buobao.service.manager.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/7/23.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public BaseDao<User, String> getBaseDao() {
        return userDao;
    }

    @Override
    public Boolean checkUserAccess(String userName,String psw){
        Map<String,Object> rmp = new HashMap();
        rmp.put("name",userName);
        rmp.put("psw",psw);
        rmp.put("accountState", AccountState.NORMAL);
        List<User> userList = (List<User>) this.findByPager(new Pager(0),rmp).getList();
        if (userList.size() > 0)
            return true;
        return false;
    }
}
