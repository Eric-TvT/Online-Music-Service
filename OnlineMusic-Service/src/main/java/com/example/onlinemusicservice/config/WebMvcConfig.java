package com.example.onlinemusicservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加配置类 方便跨域访问
 * 跨域指的是浏览器不能执行其他网站的脚本，从一个域名的网页去请求另一个域名的资源时，域
 * 名、端口、协议任一不同，都是跨域。跨域是由浏览器的同源策略造成的，是浏览器施加的安全限制
 * SpringBoot解决跨域方案有多种，重写WebMvcConfigurer是全局解决跨域方案。
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor())
                .addPathPatterns("/**");
    }
}
