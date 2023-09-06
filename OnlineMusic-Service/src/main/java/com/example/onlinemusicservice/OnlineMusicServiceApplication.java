package com.example.onlinemusicservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.onlinemusicservice.mapper")
public class OnlineMusicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineMusicServiceApplication.class, args);
    }

}
