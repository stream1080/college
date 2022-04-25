package com.stream.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author stream
 * @since 2022/4/25 23:09
 */
@Data
public class CourseCollectVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseId; //课程id
    private String title;//标题
    private BigDecimal price;//价格
    private Integer lessonNum;//课时数
    private String cover;//封面
    private String gmtCreate;//收藏时间
    private String teacherName;//讲师
}
