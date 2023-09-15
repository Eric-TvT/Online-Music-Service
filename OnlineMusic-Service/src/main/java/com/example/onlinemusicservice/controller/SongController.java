package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SongRequest;
import com.example.onlinemusicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * admin-歌手管理-歌曲管理控制类（Controller层）
 */
@RestController
public class SongController {

    @Autowired
    private SongService songService;

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
}
