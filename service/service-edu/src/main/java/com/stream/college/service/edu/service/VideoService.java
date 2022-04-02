package com.stream.college.service.edu.service;

import com.stream.college.service.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface VideoService extends IService<Video> {

    void removeMediaVideoById(String id);

    void removeMediaVideoByChapterId(String chapterId);

    void removeMediaVideoByCourseId(String courseId);

}
