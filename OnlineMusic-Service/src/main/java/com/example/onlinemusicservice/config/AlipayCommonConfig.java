package com.example.onlinemusicservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 支付宝沙箱通用支付配置类
 * @Author: Jason
 * @date: 2023.6.29
 */
@Component
@ConfigurationProperties(prefix = "alipay")
@Data
public class AlipayCommonConfig {
    /**
     * 对应支付宝APPID
     */
    private String app_id;
    /**
     * 应用私钥
     */
    private String app_private_key;
    /**
     *编码格式
     */
    private String charset;
    /**
     *支付宝公钥
     */
    private String alipay_public_key;
    /**
     *支付宝网关地址
     */
    private String gateway_url;
    private String format;
    /**
     * 签名方式
     */
    private String sign_type;
    /**
     * 支付宝异步通知路径,
     * 付款完毕后会异步调用本项目的方法,
     * 必须为公网地址
     */
    private String notify_url;
    /**
     * 支付宝同步通知路径,
     * 也就是当付款完毕后跳转本项目的页面,
     * 可以不是公网地址
     */
    private String return_url;
    /**
     * 沙箱登录URL
     */
    private String login_url;
    /**
     * 支付后的返回项目地址
     */
    private String refresh_url;
}

