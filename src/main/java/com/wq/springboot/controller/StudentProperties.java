package com.wq.springboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getS_age() {
        return s_age;
    }

    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }

    private String s_name;
    private Integer s_age;
}
