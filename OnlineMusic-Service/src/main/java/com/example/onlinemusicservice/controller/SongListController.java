package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public R songList() {
        return songListService.songList();
    }
}
