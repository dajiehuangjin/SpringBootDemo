package com.wq.springboot;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.ComponentScan;

//java.lang.ClassCastException: org.springframework.orm.jpa.EntityManagerHolder cannot be cast to org.springframework.orm.hibernate5.SessionHolder
/*
 *
 * @SpringBootApplication 是 Spring Boot 的核心注解，
 * 它是一个组合注解，该注解组合了：@Configuration、@EnableAutoConfiguration、@ComponentScan
 * 若不是用 @SpringBootApplication 注解也可以使用这三个注解代替
 */
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@SpringBootApplication
//(scanBasePackages="com.wq.springboot")
@MapperScan(basePackages="com.wq.springboot.mapper")
// @ComponentScan(basePackages={"com.wq.springboot.service","com.wq.springboot.common.dao"})
@ServletComponentScan(basePackages = {"com.wq.springboot.filter", "com.wq.springboot.listener"})
//@EnableTransactionManagement(proxyTargetClass = true) // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);
        
        System.out.println("List all beans: ");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }        
    }

}
