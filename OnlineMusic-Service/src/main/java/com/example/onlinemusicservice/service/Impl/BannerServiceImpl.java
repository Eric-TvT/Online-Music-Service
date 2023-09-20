package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.mapper.BannerMapper;
import com.example.onlinemusicservice.model.domain.Banner;
import com.example.onlinemusicservice.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图接口实现
 * @author niit
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Cacheable(value = "banner", key = "'list'")  //放在缓存中 redis 是以key-value进行存储的
    @Override
    public List<Banner> getAllBanner() {
        System.out.println("===========没有执行缓存查询");
        return bannerMapper.selectList(null);
    }
}
