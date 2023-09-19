package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 评论表
 */
@TableName("comment")
@Data
public class Comment {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer songId;

    private Integer songListId;

    /** 评论内容 */
    private String content;

    private Date createTime;

    /** 评价对象：0-歌曲，1-歌单 */
    private Byte type;
    /** 点赞数 */
    private Integer up;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
