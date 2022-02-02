package com.stream.mooc.service.edu.service.impl;

import com.stream.mooc.service.edu.entity.Course;
import com.stream.mooc.service.edu.mapper.CourseMapper;
import com.stream.mooc.service.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
