package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Comment;

/**
 * admin-歌单管理-评论管理（service层）
 */
public interface CommentService extends IService<Comment> {
    /**
     * 根据歌单id查询评论列表
     * @param songListId
     * @return
     */
    R commentListOfSongListId(int songListId);
}