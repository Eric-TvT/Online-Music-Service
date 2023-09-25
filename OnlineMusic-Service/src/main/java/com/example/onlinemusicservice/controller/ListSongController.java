package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListSongController {
    @Autowired
    private ListSongService listSongService;
    /**
     * 根据歌单id获取歌曲列表
     * @param songListId
     * @return
     */
    @GetMapping("/listSong/detail")
    public R listSongOfSongId(@RequestParam Integer songListId){
        return listSongService.listSongOfSongId(songListId);
    }
}
