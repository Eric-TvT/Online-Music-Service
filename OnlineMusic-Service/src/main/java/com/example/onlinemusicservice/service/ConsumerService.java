package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Consumer;

/**
 * admin-用户管理（Service层）
 */
public interface ConsumerService extends IService<Consumer> {
    R allUser();
    R deleteUser(Integer id);
}



