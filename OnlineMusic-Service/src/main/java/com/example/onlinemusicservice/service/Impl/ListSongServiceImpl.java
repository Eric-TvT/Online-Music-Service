package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.ListSongMapper;
import com.example.onlinemusicservice.model.domain.ListSong;
import com.example.onlinemusicservice.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;
    @Override
    public R listSongOfSongId(Integer songListId) {
        QueryWrapper<ListSong> queryWrapper = new QueryWrapper<>();
        //设置查询条件---精确查询
        queryWrapper.eq("song_list_id",songListId);

        return R.success("查询成功", listSongMapper.selectList(queryWrapper));
    }
}
