package com.stream.college.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.edu.entity.CourseCollect;
import com.stream.college.service.edu.entity.vo.CourseCollectVo;

import java.util.List;

/**
 * <p>
 * 课程收藏 服务类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface CourseCollectService extends IService<CourseCollect> {

    boolean isCollect(String courseId, String id);

    void saveCourseCollect(String courseId, String id);

    List<CourseCollectVo> selectListByMemberId(String id);

    boolean removeCourseCollect(String courseId, String id);
}
