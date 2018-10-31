package com.wq.springboot;

import com.wq.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class SpringbootConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //当设置多个拦截器时，先按顺序调用preHandle方法，然后逆序调用每个拦截器的postHandle 和afterCompletion方法
        ///告知拦截器：/static/** 与 /templates/** 不需要拦截 （配置的是 路径）
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/static/**", "/templates/**");
    }
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/root/www/test/upload");
    }
}
