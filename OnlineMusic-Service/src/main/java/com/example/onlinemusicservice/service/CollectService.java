package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Collect;

/**
 * 收藏接口-（service层接口）
 */
public interface CollectService extends IService<Collect> {
    /**
     * 通过userid去查询用户收藏的列表数据接口
     * @param userId
     * @return
     */
    R collectionOfUser(Integer userId);
}

