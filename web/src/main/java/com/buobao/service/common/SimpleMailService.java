package com.buobao.service.common;

import com.buobao.bean.Email;
import com.buobao.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


/**
 * Created by dqf on 2015/7/24.
 */
public class SimpleMailService {
    private static Logger logger = LoggerFactory.getLogger(SimpleMailService.class);
    private JavaMailSender mailSender;
    private String textTemplate;

    public SimpleMailService(){}

    public void sendNotificationMail(String userName, String authcode){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("buobao<1039163450@qq.com>");
        msg.setTo(userName);
        msg.setSubject("注册邮箱验证码");
        msg.setText("[验证码]"+authcode);

        try{
            this.mailSender.send(msg);
        } catch (Exception e){

        }
    }

    public void sendRegisterAuthCodeMail(String username, String authcode) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("buobao<1039163450@qq.com>");
        msg.setTo(username);
        msg.setSubject("用户注册邮箱验证码");
        msg.setText("【code】" + authcode);

        try {
            this.mailSender.send(msg);
        } catch (Exception e) {
            ;
        }

    }

    public void send(Email email){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("buobao<1039163450@qq.com>");
        msg.setTo(email.getAccount());
        msg.setSubject(email.getSubject());
        msg.setText(email.getBody());

        try {
            this.mailSender.send(msg);
            LogUtil.info("邮件已发送至["+email.getAccount()+"]");
        }catch (Exception e){
            logger.error("发送邮件失败",e);
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTextTemplate(String textTemplate) {
        this.textTemplate = textTemplate;
    }
}






























