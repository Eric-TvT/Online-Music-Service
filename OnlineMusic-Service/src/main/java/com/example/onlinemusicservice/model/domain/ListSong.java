package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 歌单歌曲列表实体类
 */
@TableName(value = "list_song")
@Data
public class ListSong {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer songId;

    private String songListId;


}
