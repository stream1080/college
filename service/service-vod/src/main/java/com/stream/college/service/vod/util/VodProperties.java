package com.stream.college.service.vod.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author stream
 * @since 2022/3/27 20:20
 */
@Data
@Component
@ConfigurationProperties(prefix="aliyun.vod")
public class VodProperties {

    private String keyid;

    private String keysecret;

    private String templateGroupId;

    private String workflowId;

}
