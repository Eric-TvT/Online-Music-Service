package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 实现评价歌单（POJO 类）
 */
@TableName(value = "rank_list")
@Data
public class RankList implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 歌单id */
    private Long songListId;
    /** 用户id */
    private Long consumerId;
    /** 用户评分 */
    private Integer score;
}
