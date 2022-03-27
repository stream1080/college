package com.stream.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author stream
 * @since 2022/3/27 14:03
 */
@Data
public class ChapterVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private Integer sort;

    private List<VideoVo> children = new ArrayList<>();

}
