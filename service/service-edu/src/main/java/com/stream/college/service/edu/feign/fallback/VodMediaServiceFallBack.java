package com.stream.college.service.edu.feign.fallback;


import com.stream.college.common.utils.result.R;
import com.stream.college.service.edu.feign.VodMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stream
 * @since 2022/3/27 23:38
 */
@Service
@Slf4j
public class VodMediaServiceFallBack implements VodMediaService {
    @Override
    public R removeVideo(String vodId) {
        log.info("removeVideo 熔断保护");
        return R.error();
    }

    @Override
    public R removeVideoByIdList(List<String> videoIdList) {
        log.info("removeVideoByIdList 熔断保护");
        return R.error();
    }
}
