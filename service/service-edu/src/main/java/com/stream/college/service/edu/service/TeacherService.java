package com.stream.college.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.edu.entity.Teacher;
import com.stream.college.service.edu.entity.vo.TeacherQueryVo;

import java.util.List;
import java.util.Map;

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

    /**
     * 删除讲师头像
     *
     * @param id
     * @return
     */
    Boolean removeAvatarById(String id);


    /**
     * 查看讲师信息
     *
     * @param id
     * @return
     */
    Map<String, Object> selectTeacherInfoById(String id);

    /**
     * 获取热门讲师
     *
     * @return
     */
    List<Teacher> selectHotTeacher();

    List<Map<String, Object>> selectNameList(String key);
}
