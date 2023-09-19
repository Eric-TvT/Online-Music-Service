package com.example.onlinemusicservice.model.response;

import lombok.Data;

import java.util.Date;

/**
 * 另外因为要在评论列表中显示用户名，但评论表中没有用户姓名，只有用户ID，所以需要创建一个
 * ResponsePO来封装评论与用户数据并返回给前端：
 */
@Data
public class CommentResponse {

    private Integer id;

    private Integer userId;

    private Integer songId;

    private Integer songListId;

    /**
     * 评论内容
     */
    private String content;

    private Date createTime;

    /**
     * 评价对象：0-歌曲，1-歌单
     */
    private Byte type;
    /**
     * 点赞数
     */
    private Integer up;

    private String userName;
}

