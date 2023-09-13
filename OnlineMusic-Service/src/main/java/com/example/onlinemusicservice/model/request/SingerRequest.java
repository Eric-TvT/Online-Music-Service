package com.example.onlinemusicservice.model.request;

import lombok.Data;

import java.util.Date;
/**
 * 用于接收admin-前端添加歌手请求的参数
 */
@Data
public class SingerRequest {
    private Integer id;
    private String name;
    private Byte sex;
    private String pic;
    private Date birth;
    private String location;
    private String introduction;
}

