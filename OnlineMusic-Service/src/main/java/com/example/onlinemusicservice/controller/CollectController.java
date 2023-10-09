package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.CollectRequest;
import com.example.onlinemusicservice.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收藏接口控制类（controller层）
 */
@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;
    /**
     * 查询返回的指定用户 ID 收藏的列表
     */
    // 返回的指定用户 ID 收藏的列表
    @GetMapping("/collection/detail")
    public R collectionOfUser(@RequestParam Integer userId) {
        return collectService.collectionOfUser(userId);
    }

    /**
     * 用户添加收藏歌曲
     * @param addCollectRequest
     * @return
     */
    @PostMapping("collection/add")
    public R addCollectionOfUser(@RequestBody CollectRequest addCollectRequest){
        return collectService.addCollectionOfUser(addCollectRequest);

    }

    /**
     * 用户取消收藏歌曲
     * @param userId
     * @param songId
     * @return
     */
    @DeleteMapping("/collection/delete")
    public R deleteCollection(@RequestParam Integer userId, @RequestParam Integer songId) {
        return collectService.deleteCollect(userId, songId);
    }


    // 是否收藏歌曲
    @PostMapping("/collection/status")
    public R isCollection(@RequestBody CollectRequest isCollectRequest) {
        return collectService.existSongId(isCollectRequest);

    }
}

