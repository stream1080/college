package com.stream.mooc.service.edu.service.impl;

import com.stream.mooc.service.edu.entity.Video;
import com.stream.mooc.service.edu.mapper.VideoMapper;
import com.stream.mooc.service.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
