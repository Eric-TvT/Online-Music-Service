package com.example.onlinemusicservice.model.request;

import lombok.Data;

import java.util.Date;

/**
 * 用于接收用户端-前端登入请求的参数
 */
@Data
public class CommentRequest {
    private Integer id;
    private Integer userId;
    private Integer songId;
    private Integer songListId;
    private String content;
    private Date createTime;
    private Byte nowType;
    private Integer up;//点赞
}
