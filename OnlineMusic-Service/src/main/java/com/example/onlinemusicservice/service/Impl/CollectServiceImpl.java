package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.CollectMapper;
import com.example.onlinemusicservice.model.domain.Collect;
import com.example.onlinemusicservice.model.request.CollectRequest;
import com.example.onlinemusicservice.service.CollectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * userId收藏接口（service层接口实现类）
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 查询userid收藏的信息
     * @param userId
     * @return
     */
    @Override
    public R collectionOfUser(Integer userId) {
        //根据userid查询该用户的收藏信息
        //1.使用QueryWrapper设置查询条件
        QueryWrapper<Collect> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        //  2.调用mybatis提供的查询列表的方法

        return R.success("用户收藏", collectMapper.selectList(queryWrapper));
    }

    /**
     * 用户添加收藏歌曲
     * @param addCollectRequest
     * @return
     */
    @Override
    public R addCollectionOfUser(CollectRequest addCollectRequest) {
        Collect collect = new Collect();
        BeanUtils.copyProperties(addCollectRequest, collect);
        //设置收藏时间为系统当前时间
        collect.setCreateTime(new Date());
        int i =collectMapper.insert(collect);
        if (i > 0){
            return R.success("收藏成功",true);
        }else {
            return R.error("收藏失败");
        }

    }
    /**
     * 用户取消收藏歌曲
     */
    @Override
    public R deleteCollect(Integer userId, Integer songId) {

        QueryWrapper<Collect> collectQueryWrapper=new QueryWrapper<>();
        collectQueryWrapper.eq("user_id",userId);
        collectQueryWrapper.eq("song_id",songId);
        int i =collectMapper.delete(collectQueryWrapper);
        if (i > 0){
            return R.success("取消收藏成功",true);
        }else {
            return R.error("取消收藏失败");
        }
    }

    /**
     * 查看是否收藏
     * @param isCollectRequest
     * @return
     */
    @Override
    public R existSongId(CollectRequest isCollectRequest) {
        QueryWrapper<Collect> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",isCollectRequest.getUserId());
        queryWrapper.eq("song_id",isCollectRequest.getSongId());
        if (collectMapper.selectCount(queryWrapper) > 0) {
            return R.success("已收藏", true);
        } else {
            return R.success("未收藏", false);
        }
    }
}
