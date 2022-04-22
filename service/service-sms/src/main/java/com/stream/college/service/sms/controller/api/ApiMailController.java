package com.stream.college.service.sms.controller.api;

import com.stream.college.common.utils.exception.CollegeException;
import com.stream.college.common.utils.result.R;
import com.stream.college.common.utils.result.ResultCodeEnum;
import com.stream.college.common.utils.util.FormUtils;
import com.stream.college.common.utils.util.RandomUtils;
import com.stream.college.service.sms.service.MailService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author stream
 * @since 2022/4/16 17:47
 */
@Slf4j
@RestController
@RequestMapping("/api/mail")
@Api(tags = "邮件管理")
public class ApiMailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("send/{email}")
    public R getCode(@PathVariable String email) {

        //校验邮箱是否合法
        if (StringUtils.isEmpty(email) || !FormUtils.isEmail(email)) {
            return R.error().message("请输入正确的邮箱");
        }
        //生成验证码
        String code = RandomUtils.getSixBitRandom();
        log.info("email: {}, code: {}", email, code);
        //将验证码存入redis缓存
        redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);

        new Thread(() -> {
            //发送验证码
            try {
                mailService.sendCode(email, code, "verification.html");
            } catch (Exception e) {
                log.error(String.valueOf(e));
                throw new CollegeException(ResultCodeEnum.MAIL_SEND_ERROR);
            }
        }).start();

        return R.ok().message("邮件发送成功");
    }
}
