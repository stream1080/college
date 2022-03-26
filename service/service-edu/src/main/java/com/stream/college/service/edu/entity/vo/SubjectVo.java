package com.stream.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author stream
 * @since 2022/3/26 20:34
 */
@Data
public class SubjectVo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private Integer sort;

    private List<SubjectVo> children = new ArrayList<>();
}
