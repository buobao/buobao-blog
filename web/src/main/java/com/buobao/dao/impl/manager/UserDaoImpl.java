package com.buobao.dao.impl.manager;

import com.buobao.dao.impl.BaseDaoImpl;
import com.buobao.dao.manager.UserDao;
import com.buobao.entity.manager.User;
import org.springframework.stereotype.Repository;

/**
 * Created by dqf on 2015/7/23.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {
}
