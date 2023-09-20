package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.model.domain.Banner;

import java.util.List;

/**
 * 轮播图接口
 * @author niit
 */
public interface BannerService extends IService<Banner> {
    /**
     * 返回所有的轮播图信息
     * @return
     */
    List<Banner> getAllBanner();
}

