package com.stream.college.service.cms.feign.fallback;

import com.stream.college.common.utils.result.R;
import com.stream.college.service.cms.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
@Slf4j
@Service
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error().message("调用超时");
    }
}
