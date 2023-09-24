package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SongRequest;
import com.example.onlinemusicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

/**
 * admin-歌手管理-歌曲管理控制类（Controller层）
 */
@RestController
public class SongController {

    @Autowired
    private SongService songService;


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }



    /**
     * 根据歌手Id查询歌曲列表
     * @param
     * @return
     */
    @GetMapping("/song/singer/detail")
    public R selectSongsBySingerId(@RequestParam int singerId) {
        return songService.selectSongsBySingerId(singerId);
    }

    /**
     * 更新歌曲
     * @param songRequest
     * @return
     */
    @PostMapping("/song/update")
    public R updateSong(@RequestBody SongRequest songRequest){
        return songService.updateSong(songRequest);
    }

    /**
     * 删除歌曲
     * @param id
     * @return
     */
    @DeleteMapping("/song/delete")
    public R deleteSong(@RequestParam int id){
        return songService.deleteSong(id);
    }

    /**
     * 添加歌曲
     * @param songRequest
     * @return
     */
    @PostMapping("/song/add")
    public R addSinger( SongRequest songRequest,@RequestParam("file") MultipartFile mpfile){
        return songService.addSong(songRequest,mpfile);
    }

    /**
     * 更新歌曲 图片
     * @param urlFile  上传的图片文件
     * @param id 根据id
     * @return
     */
    @PostMapping("/song/img/update")
    public R updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return songService.updateSongPic(urlFile, id);
    }

    /**
     *  TODO admin-首页歌曲总数
     * @return
     */
    @GetMapping("/song")
    public R allSong(){
        return songService.allSong();
    }



    /**TODO 用户端  这块就是前端显现相应的歌单list
     * 用户端首页搜歌曲（模糊）
     * 根据name查询歌曲信息
     * @param name
     * @return
     */
    @GetMapping("/song/singerName/detail")
    public R songOfSingerName(@RequestParam String name) {
        return songService.songOfSingerName(name);
    }

}
