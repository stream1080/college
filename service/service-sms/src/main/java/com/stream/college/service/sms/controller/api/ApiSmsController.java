package com.stream.college.service.sms.controller.api;

import com.aliyuncs.exceptions.ClientException;
import com.stream.college.common.utils.exception.CollegeException;
import com.stream.college.common.utils.result.R;
import com.stream.college.common.utils.result.ResultCodeEnum;
import com.stream.college.common.utils.util.FormUtils;
import com.stream.college.common.utils.util.RandomUtils;
import com.stream.college.service.sms.service.SmsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author stream
 * @since 2022/4/3 19:53
 */
@Slf4j
@RestController
@RequestMapping("/api/sms")
@Api(tags = "短信管理")
public class ApiSmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("send/{mobile}")
    public R getCode(@PathVariable String mobile) throws ClientException {

        //校验手机号是否合法
        if (StringUtils.isEmpty(mobile) || !FormUtils.isMobile(mobile)) {
            log.error("手机号不正确，mobile：{}", mobile);
            new CollegeException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
            return R.error().message("手机号不正确").code(28001);
        }

        //生成验证码
        String checkCode = RandomUtils.getFourBitRandom();
        log.error("手机验证码：{}，mobile：{}", checkCode, mobile);
        //发送验证码
//        smsService.send(mobile, checkCode);

        //存储验证码到redis
        redisTemplate.opsForValue().set(mobile, checkCode, 5, TimeUnit.MINUTES);

        return R.ok().message("短信发送成功");
    }

}
