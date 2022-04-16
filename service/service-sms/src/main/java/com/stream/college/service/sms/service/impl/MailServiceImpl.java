package com.stream.college.service.sms.service.impl;

import com.stream.college.service.sms.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @author stream
 * @since 2022/4/16 17:51
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void sendCode(String email, String code, String template) throws IOException, TemplateException, MessagingException {

        // 获得模板
        Template templateTem = freeMarkerConfigurer.getConfiguration().getTemplate(template);
        // 使用Map作为数据模型，定义属性和值
        Map<String, Object> model = new HashMap<>();
        // 将验证码放入model
        model.put("code", code);
        // 传入数据模型到模板，替代模板中的占位符，并将模板转化为html字符串
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(templateTem, model);

        //设置一些必要的值
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        message.setSubject("【慕课学院】 - 注册验证码"); //标题
        helper.setTo(email); //接收人的邮箱

        //第一个参数：模板
        //第二个参数：格式是否为html
        helper.setText(templateHtml, true);
        //发送邮件
        javaMailSender.send(message);
    }
}
