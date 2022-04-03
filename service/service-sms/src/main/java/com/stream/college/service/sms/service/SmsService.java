package com.stream.college.service.sms.service;

import com.aliyuncs.exceptions.ClientException;

/**
 * @author stream
 * @since 2022/4/3 19:53
 */
public interface SmsService {
    void send(String mobile, String checkCode) throws ClientException;
}
