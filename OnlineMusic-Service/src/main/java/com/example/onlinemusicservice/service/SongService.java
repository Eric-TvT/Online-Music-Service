package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Song;
import com.example.onlinemusicservice.model.request.SongRequest;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 删除歌曲        批量删除是调用删除的方法
     * @param id
     * @return
     */
    public R deleteSong(Integer id);

    /**
     * 添加歌曲
     * @param addSongRequest
     * @param mpfile 表示文件二进制流
     * @return
     */
    public R addSong(SongRequest addSongRequest, MultipartFile mpfile);

    /**
     * 更新图片
     * @param urlFile 上传的图片文件
     * @param id 歌曲id
     * @return
     */
    public R updateSongPic(MultipartFile urlFile, int id);

    /**TODO admin-首页歌曲总数s
     * 首页歌曲总数
     * @return
     */
    public R allSong();

    /**
     * 根据歌手名称查询歌曲
     * @param name
     * @return
     */
    public R songOfSingerName(String name);

}
