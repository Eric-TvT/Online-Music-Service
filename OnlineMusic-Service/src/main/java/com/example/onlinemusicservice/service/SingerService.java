package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Singer;

/**
 * admin-歌手管理（service层接口）
 */
public interface SingerService extends IService<Singer> {

    R allSinger();
}

