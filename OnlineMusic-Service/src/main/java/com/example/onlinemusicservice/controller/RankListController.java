package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.RankListRequest;
import com.example.onlinemusicservice.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class RankListController {
    @Autowired
    private RankListService rankListService;

    /**
     * 提交评分
     * @param rankListAddRequest 接受前端请求的参数
     * @return
     */
    @PostMapping("/rankList/add")
    public R addRank(@RequestBody RankListRequest rankListAddRequest) {
        return rankListService.addRank(rankListAddRequest);
    }
    /**
     * 根据歌单id查询歌单评分（评分=总分/数量）
     * 取指定歌单的评分
     * @param songListId
     * @return
     */

    @GetMapping("/rankList")
    public R rankOfSongListId(@RequestParam Long songListId) {
        //TODO 这里需要调用 Service 获取实际评分
        return rankListService.rankOfSongListId(songListId);
    }
    /**
     * 获取根据歌单ID和用户ID获取评分
     * @param consumerId
     * @param songListId
     * @return
     */
    @GetMapping("/rankList/user")
    public R getRankScroe(@RequestParam long consumerId, @RequestParam long songListId) {
        return rankListService.getRankScroe(consumerId,songListId);
    }

}
