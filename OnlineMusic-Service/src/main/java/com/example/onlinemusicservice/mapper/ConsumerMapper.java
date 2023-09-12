package com.example.onlinemusicservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlinemusicservice.model.domain.Consumer;

/**
 * admin-用户管理Mapper层接口
 */
public interface ConsumerMapper extends BaseMapper<Consumer> {
    //添加自定义方法，用来完成批量删除

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    int deleteByIds(String ids);

}
