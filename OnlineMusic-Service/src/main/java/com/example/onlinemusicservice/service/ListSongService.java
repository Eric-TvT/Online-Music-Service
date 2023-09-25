package com.example.onlinemusicservice.service;

import com.example.onlinemusicservice.common.R;

/**
 * 歌单歌曲接口service
 */
public interface ListSongService {
    /**
     * @Description: 获取指定歌单id下的所有歌曲列表
     **/
    public R listSongOfSongId(Integer songListId);
}
