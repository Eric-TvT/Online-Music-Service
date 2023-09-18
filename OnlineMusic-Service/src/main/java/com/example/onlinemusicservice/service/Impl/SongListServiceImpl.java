package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SongListMapper;
import com.example.onlinemusicservice.model.domain.SongList;
import com.example.onlinemusicservice.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * admin-歌单管理接口（service层接口实现类）
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {
    @Autowired
    private SongListMapper songListMapper;
    /**
     * 查询歌单列表
     *
     * @return
     */
    @Override
    public R songList() {
        return R.success("查询成功",songListMapper.selectList(null));
    }
}
