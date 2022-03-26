package com.stream.college.service.edu.feign.fallback;


import com.stream.college.common.utils.result.R;
import com.stream.college.service.edu.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author stream
 * @since 2022/3/26 22:58
 */
@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error();
    }

}
