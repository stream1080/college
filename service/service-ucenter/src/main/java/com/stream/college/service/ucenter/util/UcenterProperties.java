package com.stream.college.service.ucenter.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author stream
 * @since 2022/4/3 20:13
 */
@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="wx.open")
public class UcenterProperties {

    private String appId;

    private String appSecret;

    private String redirectUri;

}