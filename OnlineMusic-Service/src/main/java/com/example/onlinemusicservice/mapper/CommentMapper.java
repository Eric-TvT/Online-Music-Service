package com.example.onlinemusicservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlinemusicservice.model.domain.Comment;
import com.example.onlinemusicservice.model.response.CommentResponse;

import java.util.List;

/**
 * admin-歌单管理-评论管理（Mapper层）
 */
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * @Description: 根据歌单id查询所有评论列表
     * @CreateTime:
     * @param: songListId
     * @return:
     **/
    List<CommentResponse> selectCommentListBySongListId(Integer songListId);
}
