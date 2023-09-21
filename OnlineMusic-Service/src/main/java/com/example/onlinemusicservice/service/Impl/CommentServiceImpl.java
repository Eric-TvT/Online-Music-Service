package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.CommentMapper;
import com.example.onlinemusicservice.model.domain.Comment;
import com.example.onlinemusicservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * admin-歌单管理-评论管理（service接口实现类）
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 歌单管理-评论管理
     * @param songListId
     * @return
     */
    @Override
    public R commentListOfSongListId(int songListId) {
        return R.success("查询成功", commentMapper.selectCommentListBySongListId(songListId));
    }
}
