package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 歌曲表POJO（song）
 */
@TableName(value = "song")
@Data
public class Song {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 歌手ID
     */
    private Integer singerId;
    /**
     * 歌曲名
     */
    private String name;
    private String introduction;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private String pic;
    /**
     * 歌词
     */
    private String lyric;
    private String url;
    /**
     * 歌曲单价
     */
    private Double price;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
