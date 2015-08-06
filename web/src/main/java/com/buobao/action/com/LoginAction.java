package com.buobao.action.com;

import com.buobao.action.BaseAction;
import com.buobao.entity.manager.User;
import com.buobao.service.manager.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by dqf on 2015/7/22.
 */
@ParentPackage("com")
public class LoginAction extends BaseAction{
    private static final transient Logger log = LoggerFactory.getLogger(LoginAction.class);

    @Resource
    private UserService userService;

    private String userName;
    private String psw;

    private User user;


    @Override
    public String execute(){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(psw)){
                return "login";
            }
            else{
                if (userService.checkUserAccess(userName,psw)){
                    UsernamePasswordToken token = new UsernamePasswordToken(user.getId(),user.getPsw());
                    try{
                        currentUser.login(token);
                    } catch (UnknownAccountException uae){
                        log.info("There is no user with username of "+token.getPrincipal());
                        return "login";
                    } catch (IncorrectCredentialsException ice){
                        log.info("Password for account "+token.getPrincipal() + "was incorrect!");
                        return "login";
                    } catch (LockedAccountException lae){
                        log.info("The account for username "+token.getPrincipal() + " is locked. Please contact your administrator to unlock it.");
                        return "login";
                    } catch (AuthenticationException ae){
                        log.info("Other exceptions.");
                        return "login";
                    }
                } else{
                    log.info("Account Error");
                    return "toindex";
                }
            }
        }
        return "toindex";
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

}




























