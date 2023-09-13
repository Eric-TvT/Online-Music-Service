package com.example.onlinemusicservice.model.request;

import lombok.Data;

import java.util.Date;

/**
 * 用于接收admin-前端歌手管理的歌曲管理前端请求的参数
 */
@Data
public class SongRequest {
    private Integer id;
    private Integer singerId;
    private String name;
    private String introduction;
    private Date createTime;
    private Date updateTime;
    private String pic;
    private String lyric;
    private String url;
    private Double price;
}

