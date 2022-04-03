package com.stream.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stream
 * @since 2022/3/27 14:04
 */
@Data
public class WebCourseQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subjectParentId;

    private String subjectId;

    private String buyCountSort;

    private String gmtCreateSort;

    private String priceSort;

    private Integer type;

}
