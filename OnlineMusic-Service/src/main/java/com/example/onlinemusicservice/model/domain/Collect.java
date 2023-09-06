package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * collect表的字段-POJO
 */
@TableName(value = "collect")
@Data
public class Collect {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Byte type;
    private Integer songId;
    private Integer songListId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

