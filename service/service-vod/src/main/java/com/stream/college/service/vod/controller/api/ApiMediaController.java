package com.stream.college.service.vod.controller.api;

import com.stream.college.common.utils.exception.CollegeException;
import com.stream.college.common.utils.result.R;
import com.stream.college.common.utils.result.ResultCodeEnum;
import com.stream.college.common.utils.util.ExceptionUtils;
import com.stream.college.service.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stream
 * @since 2022/4/25 21:37
 */
@Api(description="阿里云视频点播")
@RestController
@RequestMapping("/api/vod/media")
@Slf4j
public class ApiMediaController {

    @Autowired
    private VideoService videoService;

    @GetMapping("get-play-auth/{videoSourceId}")
    public R getPlayAuth(
            @ApiParam(value = "阿里云视频文件的id", required = true)
            @PathVariable String videoSourceId){

        try{
            String playAuth = videoService.getPlayAuth(videoSourceId);
            return  R.ok().message("获取播放凭证成功").data("playAuth", playAuth);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new CollegeException(ResultCodeEnum.FETCH_PLAYAUTH_ERROR);
        }
    }
}

