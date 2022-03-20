package com.stream.college.service.oss.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author stream
 * @since 2022/3/20 14:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {

    private String endpoint;

    private String keyid;

    private String keysecret;

    private String bucketname;

}
