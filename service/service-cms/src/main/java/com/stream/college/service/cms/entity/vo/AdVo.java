package com.stream.college.service.cms.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
@Data
public class AdVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String title;

    private Integer sort;

    private String type;

}
