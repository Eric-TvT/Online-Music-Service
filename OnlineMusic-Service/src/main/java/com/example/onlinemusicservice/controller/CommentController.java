package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.CommentRequest;
import com.example.onlinemusicservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论控制类（controller层）
 */
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;
    /**
     * 根据歌单ID查询评论列表
     *
     * @param songListId
     * @return
     */
    @GetMapping("/comment/songList/detail")
    public R commentListOfSongListId(@RequestParam int songListId) {
        return commentService.commentListOfSongListId(songListId);
    }

    /**
     * 用户对歌单添加评论
     * @param addCommentRequest
     * @return
     */
    @PostMapping("/comment/add")
    public R addComment(@RequestBody CommentRequest addCommentRequest){
        return commentService.addComment(addCommentRequest);
    }

}
