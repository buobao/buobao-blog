package com.buobao.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * Created by dqf on 2015/7/22.
 */
@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {

    public MonitorRealm(){}

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*这里添加授权代码*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*这里添加认证代码*/
        UsernamePasswordToken token1 = (UsernamePasswordToken)token;
        String username = token1.getUsername();
        if (username != null && !"".equals(username)){
            if (token1.getUsername().equals("admin") && String.valueOf(token1.getPassword()).equals("123"))
                return new SimpleAuthenticationInfo(token1.getUsername(), token1.getPassword(),getName());
        }
        return null;
    }

    public void clearCachedAuthorizationInfo(String principal){
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal,getName());
        clearCachedAuthorizationInfo(principals);
    }
}

























