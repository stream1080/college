package com.stream.college.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.edu.entity.Chapter;
import com.stream.college.service.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);

}
