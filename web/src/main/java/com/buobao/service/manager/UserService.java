package com.buobao.service.manager;

import com.buobao.entity.manager.User;
import com.buobao.service.BaseService;

/**
 * Created by dqf on 2015/7/23.
 */
public interface UserService extends BaseService<User,String> {

    public Boolean checkUserAccess(String userName,String psw);
}
