package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SongMapper;
import com.example.onlinemusicservice.model.domain.Song;
import com.example.onlinemusicservice.model.request.SongRequest;
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
        queryWrapper.eq("singer_id", singerId);
        // 调用mybatis提供的查询方法
        //  2.调用mybatis提供的查询列表的方法
        return R.success("查询成功", songMapper.selectList(queryWrapper));
    }

    /**
     * 更新歌曲
     * @param updateSongRequest
     * @return
     */
    @Override
    public R updateSong(SongRequest updateSongRequest) {
        //先去获取服务端的歌曲信息，判断歌曲是否存在在进行赋值
        Song song = songMapper.selectById(updateSongRequest.getId());
        if (song != null) {
           // BeanUtils.copyProperties(updateSongRequest, song);
           song.setName(updateSongRequest.getName());
           song.setIntroduction(updateSongRequest.getIntroduction());
           song.setLyric(updateSongRequest.getLyric());
            if (songMapper.updateById(song) > 0) {
                return R.success("更新成功");
            } else {
                return R.error("更新失败");
            }
        } else {
            return R.error("歌曲不存在");
        }

    }
}
