package com.buobao.service.common;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by dqf on 2015/7/24.
 */
public class MimeMailService {
    private static final String DEFAULT_ENCODING = "utf-8";
    private static Logger logger = LoggerFactory.getLogger(MimeMailService.class);
    private JavaMailSender mailSender;
    private Template template;

    public MimeMailService(){}

    public void sendNotificationMail(String userName){
        try{
            MimeMessage e = this.mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(e, true, "utf-8");
            helper.setTo("lebron_king_james@163.com");
            helper.setFrom("877566970@qq.com");
            helper.setSubject("用户修改通知");
            String content = this.generateContent(userName);
            helper.setText(content, true);
            File attachment = this.generateAttachment();
            helper.addAttachment("mailAttachment.txt",attachment);
            this.mailSender.send(e);
            logger.info("HTML版邮件已发送至lebron_king_james@163.com");
        } catch (MessagingException e) {
            logger.error("构造邮件失败",e);
        }catch (Exception e){
            logger.error("邮件发送失败",e);
        }
    }

    private String generateContent(String userName) throws MessagingException {
        try {
            Map e = Collections.singletonMap("userName", userName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(this.template, e);
        } catch (IOException var3) {
            logger.error("生成邮件内容失败, FreeMarker模板不存在", var3);
            throw new MessagingException("FreeMarker模板不存在", var3);
        } catch (TemplateException var4) {
            logger.error("生成邮件内容失败, FreeMarker处理失败", var4);
            throw new MessagingException("FreeMarker处理失败", var4);
        }
    }

    private File generateAttachment() throws MessagingException {
        try {
            ClassPathResource e = new ClassPathResource("/email/mailAttachment.txt");
            return e.getFile();
        } catch (IOException var2) {
            logger.error("构造邮件失败,附件文件不存在", var2);
            throw new MessagingException("附件文件不存在", var2);
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setFreemarkerConfiguration(Configuration freemarkerConfiguration) throws IOException {
        this.template = freemarkerConfiguration.getTemplate("mailTemplate.ftl", "utf-8");
    }
}

























