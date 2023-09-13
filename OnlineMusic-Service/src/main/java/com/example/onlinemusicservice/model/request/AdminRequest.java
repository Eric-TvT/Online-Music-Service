package com.example.onlinemusicservice.model.request;

import lombok.Data;

/**
 * 用于接收admin管理员前端登入请求的参数
 */
@Data
public class AdminRequest {
    private Integer id;
    private String username;
    private String password;
}

