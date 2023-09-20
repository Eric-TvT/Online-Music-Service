package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannerController {

    @Autowired
    BannerService bannerService;

    /**
     * 用户端首页获取轮播图
     * @return
     */
    @GetMapping("/banner/getAllBanner")
    public R getAllBanner(){

        return R.success("获取成功",bannerService.getAllBanner());
    }
}

