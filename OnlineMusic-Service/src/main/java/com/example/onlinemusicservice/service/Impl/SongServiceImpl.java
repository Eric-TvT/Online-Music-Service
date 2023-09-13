package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SongMapper;
import com.example.onlinemusicservice.model.domain.Song;
import com.example.onlinemusicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * admin-歌手管理-歌曲管理（mapper层接口实现类）
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
    @Autowired
    private SongMapper songMapper;
    @Override
    public R selectSongsBySingerId(int singerId) {
        // 根据歌手ID查询歌曲 select * from song where singer_id = 1
        // 定义查询条件
        //调用Mapper去完成基础的查询功能
        //1.使用QueryWrapper设置查询条件
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("singer_id",singerId);
        // 调用mybatis提供的查询方法
        //  2.调用mybatis提供的查询列表的方法
        return R.success("查询成功",songMapper.selectList(queryWrapper));
    }
}
