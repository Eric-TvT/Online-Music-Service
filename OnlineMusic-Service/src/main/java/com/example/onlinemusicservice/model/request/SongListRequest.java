package com.example.onlinemusicservice.model.request;

import lombok.Data;

/**
 * 用于接收admin-前端歌单管理请求的参数
 */
@Data
public class SongListRequest {
    private Integer id;
    /** 歌单标题 */
    private String title;
    /** 歌单图片 */
    private String pic;
    /** 歌单风格 */
    private String style;
    /** 歌单介绍 */
    private String introduction;
}
