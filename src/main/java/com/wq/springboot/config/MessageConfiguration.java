package com.wq.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试 Spring Boot 配置注解使用
 */
@Configuration
public class MessageConfiguration {

    @Bean(name="my_message")
    public String my_message() {
        return "message configuration";
    }
}