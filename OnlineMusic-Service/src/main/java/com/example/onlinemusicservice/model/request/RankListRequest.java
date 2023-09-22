package com.example.onlinemusicservice.model.request;

import lombok.Data;

/**
 * 评价歌单，用于接受前端评价歌单请求的参数
 */
@Data
public class RankListRequest {
    private Long id;
    /** 歌单id */
    private Long songListId;
    /** 用户id */
    private Long consumerId;
    /** 用户评分 */
    private Integer score;
}

