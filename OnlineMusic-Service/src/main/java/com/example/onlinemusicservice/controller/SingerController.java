package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * admin-歌手管理控制类（controller层）
 */
@RestController
public class SingerController {
    @Autowired
    private SingerService singerService;

    @GetMapping("/singer")
    public R allSinger(){
        return singerService.allSinger();
    }
}

