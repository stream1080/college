package com.stream.college.service.cms.service;

import com.stream.college.service.cms.entity.Ad;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.cms.entity.vo.AdVo;

import java.util.List;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
public interface AdService extends IService<Ad> {

    IPage<AdVo> selectPage(Long page, Long limit);

    boolean removeAdImageById(String id);

    List<Ad> selectByAdTypeId(String adTypeId);
}
