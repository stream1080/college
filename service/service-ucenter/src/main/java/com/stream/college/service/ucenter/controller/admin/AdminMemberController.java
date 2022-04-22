package com.stream.college.service.ucenter.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stream.college.common.utils.result.R;
import com.stream.college.service.ucenter.entity.Member;
import com.stream.college.service.ucenter.entity.vo.MemberQueryVo;
import com.stream.college.service.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author stream
 * @since 2022/4/22 10:56
 */
@Slf4j
@Api(tags = "会员管理")
@RestController
@RequestMapping("/admin/ucenter/member")
public class AdminMemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation("会员分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象") MemberQueryVo memberQueryVo) {

        Page<Member> pageParam = new Page<>(page, limit);
        IPage<Member> pageModel = memberService.selectPage(pageParam, memberQueryVo);
        List<Member> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }
}
