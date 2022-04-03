package com.stream.college.service.edu.controller.api;


import com.stream.college.common.utils.result.R;
import com.stream.college.service.edu.entity.vo.SubjectVo;
import com.stream.college.service.edu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author stream
 * @since 2022/4/2 22:58
 */
@CrossOrigin
@Api(tags = "课程分类")
@RestController
@RequestMapping("/api/edu/subject")
public class ApiSubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("嵌套数据列表")
    @GetMapping("nested-list")
    public R nestedList() {
        List<SubjectVo> subjectVoList = subjectService.nestedList();
        return R.ok().data("items", subjectVoList);
    }
}
