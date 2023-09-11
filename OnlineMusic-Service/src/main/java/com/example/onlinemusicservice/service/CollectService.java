package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Collect;

/**
 * 收藏接口-（Service层）
 */
public interface CollectService extends IService<Collect> {
    R collectionOfUser(Integer userId);
}

