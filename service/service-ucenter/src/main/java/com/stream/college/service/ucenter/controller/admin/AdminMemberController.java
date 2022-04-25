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
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查询所有会员")
    @GetMapping("list")
    public R listAll() {
        List<Member> list = memberService.listAll();
        return R.ok().data("items", list);
    }

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

    @ApiOperation(value = "根据ID禁用会员")
    @DeleteMapping("disable/{id}")
    public R disableById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id) {
        boolean result = memberService.editDisableById(id,true);
        if (result) {
            return R.ok().message("禁用成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation(value = "根据ID解禁会员")
    @DeleteMapping("available/{id}")
    public R availableById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id) {
        boolean result = memberService.editDisableById(id,false);
        if (result) {
            return R.ok().message("解禁成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("更新会员")
    @PutMapping("update")
    public R updateById(@ApiParam("会员对象") @RequestBody Member member) {
        boolean result = memberService.updateById(member);
        if (result) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据id获取会员信息")
    @GetMapping("get/{id}")
    public R getById(@ApiParam("会员对象") @PathVariable String id) {
        Member member = memberService.getById(id);
        if (member != null) {
            member.setPassword("");
            member.setSign("");
            member.setOpenid("");
            return R.ok().data("item", member);
        } else {
            return R.error().message("数据不存在");
        }
    }
}
