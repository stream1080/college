package com.stream.college.service.sms.service;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author stream
 * @since 2022/4/16 17:49
 */
public interface MailService {

    void sendCode(String email, String code, String s) throws IOException, TemplateException, MessagingException;
}
