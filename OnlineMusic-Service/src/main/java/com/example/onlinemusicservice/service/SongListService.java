package com.example.onlinemusicservice.service;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SongListRequest;

/**
 * admin-歌单管理接口（service层接口）
 */
public interface SongListService {
    /**
     * 查询歌单列表
     *
     * @return
     */
    public R songList(String style);
    /**
     * 添加歌单
     */
    public R addSongList(SongListRequest addSongListRequest);
    /**
     * 删除歌单-----当个删除和批量删除调用多个单个删除
     */
    public R deleteSongList(Integer id);

    /**
     * 更新歌单
     * @param updateSongListRequest
     * @return
     */
    public R updateSongList(SongListRequest updateSongListRequest);


}
