package com.stream.college.service.cms.mapper;

import com.stream.college.service.cms.entity.Ad;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stream.college.service.cms.entity.vo.AdVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
public interface AdMapper extends BaseMapper<Ad> {

    List<AdVo> selectPageByQueryWrapper(
            Page<AdVo> pageParam,
            @Param(Constants.WRAPPER) QueryWrapper<AdVo> queryWrapper);
}
