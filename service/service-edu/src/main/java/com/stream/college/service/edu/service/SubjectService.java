package com.stream.college.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.edu.entity.Subject;
import com.stream.college.service.edu.entity.vo.SubjectVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 批量导入数据
     *
     * @param inputStream
     */
    void batchImport(InputStream inputStream);

    /**
     * 获取嵌套的树形数据
     *
     * @return
     */
    List<SubjectVo> nestedList();

}
