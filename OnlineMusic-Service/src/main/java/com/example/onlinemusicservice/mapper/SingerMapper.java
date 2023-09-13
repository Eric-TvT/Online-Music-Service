package com.example.onlinemusicservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlinemusicservice.model.domain.Singer;

/**
 * admin-歌手管理（Mapper层接口）
 */
public interface SingerMapper extends BaseMapper<Singer> {
    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    int deleteByIds(String ids);
}
