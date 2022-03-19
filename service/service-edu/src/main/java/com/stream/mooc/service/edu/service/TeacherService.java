package com.stream.mooc.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stream.mooc.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.mooc.service.edu.entity.vo.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 显示分页查询列表
     *
     * @param pageParam
     * @param teacherQueryVo
     * @return
     */
    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);
}
