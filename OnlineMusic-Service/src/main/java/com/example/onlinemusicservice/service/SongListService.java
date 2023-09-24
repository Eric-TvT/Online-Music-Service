package com.example.onlinemusicservice.service;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SongListRequest;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 更新歌单图片
     * @param urlFile 上传的歌单图片
     * @param id 歌单id
     * @return
     */
    public R updateSongListPic(MultipartFile urlFile, int id);

    /**
     * TODO 用户端
     * 模糊查询搜索歌单
     * @param title
     * @return
     */
    public R likeTitle(String title);
    /**
     * 客户端 歌单根据风格查询
     * 返回指定类型的歌单
     * @param style
     * @return
     */
    public R songListOfStyle(String style);

}
