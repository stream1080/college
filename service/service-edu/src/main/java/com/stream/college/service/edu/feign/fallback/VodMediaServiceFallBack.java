package com.stream.college.service.edu.feign.fallback;


import com.stream.college.common.utils.result.R;
import com.stream.college.service.edu.feign.VodMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author stream
 * @since 2022/3/27 23:38
 */
@Service
@Slf4j
public class VodMediaServiceFallBack implements VodMediaService {
    @Override
    public R removeVideo(String vodId) {
        log.info("熔断保护");
        return R.error();
    }
}
