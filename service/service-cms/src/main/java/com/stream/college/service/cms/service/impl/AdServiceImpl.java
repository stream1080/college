package com.stream.college.service.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stream.college.common.utils.result.R;
import com.stream.college.service.cms.entity.Ad;
import com.stream.college.service.cms.entity.vo.AdVo;
import com.stream.college.service.cms.feign.OssFileService;
import com.stream.college.service.cms.mapper.AdMapper;
import com.stream.college.service.cms.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author stream
 * @since 2022/4/3 15:38
 */
@Service
public class AdServiceImpl extends ServiceImpl<AdMapper, Ad> implements AdService {

    @Autowired
    private OssFileService ossFileService;

    @Override
    public IPage<AdVo> selectPage(Long page, Long limit) {

        QueryWrapper<AdVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("a.type_id", "a.sort");

        Page<AdVo> pageParam = new Page<>(page, limit);

        List<AdVo> records = baseMapper.selectPageByQueryWrapper(pageParam, queryWrapper);
        pageParam.setRecords(records);
        return pageParam;
    }

    @Override
    public boolean removeAdImageById(String id) {
        Ad ad = baseMapper.selectById(id);
        if (ad != null) {
            String imagesUrl = ad.getImageUrl();
            if (!StringUtils.isEmpty(imagesUrl)) {
                //删除图片
                R r = ossFileService.removeFile(imagesUrl);
                return r.getSuccess();
            }
        }
        return false;
    }

    /**
     * 1、查询 redis 缓存中是否存在需要的数据  hasKey
     * 2、如果缓存不存在从数据库中取出数据、并将数据存入缓存  set
     * 3、如果缓存存在则从缓存中读取数据  get
     *
     * @param adTypeId
     * @return
     */
    @Cacheable(value = "index", key = "'selectByAdTypeId'")
    @Override
    public List<Ad> selectByAdTypeId(String adTypeId) {

        QueryWrapper<Ad> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort", "id");
        queryWrapper.eq("type_id", adTypeId);
        return baseMapper.selectList(queryWrapper);
    }

}
