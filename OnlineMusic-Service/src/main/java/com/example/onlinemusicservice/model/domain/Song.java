package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 歌曲表 song-POJO（实体类）
 */
@TableName(value = "song")
@Data
public class Song {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer singerId;

    private String name;

    private String introduction;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String pic;

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
