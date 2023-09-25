package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.CommentMapper;
import com.example.onlinemusicservice.model.domain.Comment;
import com.example.onlinemusicservice.model.request.CommentRequest;
import com.example.onlinemusicservice.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /**
     * 用户对歌单添加评论
     * @param addCommentRequest
     * @return
     */
    @Override
    public R addComment(CommentRequest addCommentRequest) {
        Comment comment = new Comment();
        //属性复制
        BeanUtils.copyProperties(addCommentRequest,comment);
        //设置表type字段为
        comment.setType(addCommentRequest.getNowType());
        //设置点滴赞数为0
        comment.setUp(0);
        //评论发表时间为系统当前时间
        comment.setCreateTime(new Date());
        int i =commentMapper.insert(comment);
        if (i>0){
            return R.success("评论成功");
        }
            return R.error("评论失败");
    }
}
