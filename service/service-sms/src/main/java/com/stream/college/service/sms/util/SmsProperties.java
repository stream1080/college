package com.stream.college.service.sms.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author stream
 * @since 2022/4/3 19:53
 */
@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="aliyun.sms")
public class SmsProperties {

    private String regionId;

    private String keyId;

    private String keySecret;

    private String templateCode;

    private String signName;

}