package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SongListRequest;
import com.example.onlinemusicservice.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * admin-歌单管理控制类（Controller层）
 */
@RestController
public class SongListController {

    @Autowired
    private SongListService songListService;

    /**
     * 查询歌单列表
     *
     * @return
     */
    @GetMapping("/songList")
    public R songList(@RequestParam(required = false) String style) {
        return songListService.songList(style);
    }
    /**
     * 添加歌单
     */
    @PostMapping("/songList/add")
    public R addSongList(@RequestBody SongListRequest addSongListRequest){
        return songListService.addSongList(addSongListRequest);
    }
    /**
     * 删除歌单------当个删除和批量删除调用多个单个删除
     */
    @GetMapping("/songList/delete")
    public R deleteSongList(int id){
        return songListService.deleteSongList(id);
    }

    /**
     * 更新歌单
     * @param updateSongListRequest
     * @return
     */
    @PostMapping("/songList/update")
    public R updateSongList(@RequestBody SongListRequest updateSongListRequest){
        return songListService.updateSongList(updateSongListRequest);
    }

    /**
     * 更新歌单图片
     * @param urlFile 上传的歌单图片
     * @param id 歌单id
     * @return
     */
    @PostMapping("/songList/img/update")
    public R updateSongListPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id){
        return songListService.updateSongListPic(urlFile,id);
    }




    /**
     * TODO 这块就是前端显现相应的歌单list
     * 前后联调首页中歌单搜索栏功能 // 返回标题包含文字的歌单
     * @param title
     * @return
     */
    @GetMapping("/songList/likeTitle/detail")
    public R songListOfLikeTitle(@RequestParam String title) {
        return songListService.likeTitle('%' + title + '%');
    }

    /**
     * 客户端 歌单根据风格查询
     * 返回指定类型的歌单
     * @param style
     * @return
     */
    @GetMapping("/songList/style/detail")
    public R songListOfStyle(@RequestParam  String style){
        return songListService.songListOfStyle(style);
    }







}
