package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Song;
import com.example.onlinemusicservice.model.request.SongRequest;

/**
 * admin-歌手管理-歌曲管理（service层接口）
 */
public interface SongService extends IService<Song> {

    /**
     * 根据歌手ID查询歌曲列表
     * @param singerId
     * @return
     */
    public R selectSongsBySingerId(int singerId);

    /**
     * 更新歌曲
     * @param updateSongRequest
     * @return
     */
    public R updateSong(SongRequest updateSongRequest);
}
