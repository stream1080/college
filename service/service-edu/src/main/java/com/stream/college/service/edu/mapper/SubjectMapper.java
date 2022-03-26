package com.stream.college.service.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stream.college.service.edu.entity.Subject;
import com.stream.college.service.edu.entity.vo.SubjectVo;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 获取分类的树形数据
     *
     * @param parentId
     * @return
     */
    List<SubjectVo> selectNestedListByParentId(String parentId);

}
