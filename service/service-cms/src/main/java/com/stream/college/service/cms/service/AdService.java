package com.stream.college.service.cms.service;

import com.atguigu.guli.service.cms.entity.Ad;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.cms.entity.vo.AdVo;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
public interface AdService extends IService<Ad> {

    IPage<AdVo> selectPage(Long page, Long limit);

    boolean removeAdImageById(String id);
}
