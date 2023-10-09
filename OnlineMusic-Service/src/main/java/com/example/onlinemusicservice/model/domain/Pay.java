package com.example.onlinemusicservice.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

/**
 * @Description: 支付清单类
 * @Author: Jason
 * @date: 2023.6.29
 */
@TableName(value = "pay")
@Data
public class Pay {
    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
     * 订单题目
     */
    private String subject;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 清单编号
     */
    private String tradeNo;
    /**
     * 订单金额
     */
    private Double amount;
    /**
     * 支付类型 1表示直接支付，2表示在购物车结算
     */
    private Integer payType;
    /**
     * 支付宝成功返回的订单号
     */
    private String alipayNo;
    /**
     * 支付状态 Constants类
     */
    private Integer payStatus;
    /**
     * 支付时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 清单子项
     */
    @TableField(exist = false)
    private List<PayItem> payItems;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

