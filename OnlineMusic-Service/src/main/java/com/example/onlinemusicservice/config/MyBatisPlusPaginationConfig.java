package com.example.onlinemusicservice.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis Plus分页配置类
 */
@Configuration
public class MyBatisPlusPaginationConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //分页插件
        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor();
        //数据库类型
        pageInterceptor.setDbType(DbType.MYSQL);
        //总拦截器
        MybatisPlusInterceptor interceptors = new MybatisPlusInterceptor();
        //添加到插件列表
        interceptors.addInnerInterceptor(pageInterceptor);
        return interceptors;
    }
}
