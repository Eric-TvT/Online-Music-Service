package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Description: 支付清单子项类
 * @Author: Jason
 * @date: 2023.6.29
 */
@TableName(value = "pay_item")
@Data
public class PayItem {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer songId;
    private String tradeNo;
    private Double price;
    private Integer userId;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
