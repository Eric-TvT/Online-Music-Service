package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.CollectMapper;
import com.example.onlinemusicservice.model.domain.Collect;
import com.example.onlinemusicservice.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收藏接口（service层接口实现类）
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public R collectionOfUser(Integer userId) {
        //根据userid查询该用户的收藏信息
        //1.使用QueryWrapper设置查询条件
        QueryWrapper<Collect> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        //  2.调用mybatis提供的查询列表的方法
        return R.success("用户收藏", collectMapper.selectList(queryWrapper));
    }
}
