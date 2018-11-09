package com.wq.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;

import com.wq.springboot.config.MessageConfiguration;

/**
 * 测试控制器
 *
 * @RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
 * @RestController 缺省返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 */
@RestController
//@Controller
@RequestMapping("/hello")
public class HelloController {
    //配置文件中的标签
    @Value("${name}")
    private String name;

    //配置文件中的标签
    @Value("${number}")
    private Integer number;

    //配置文件中的标签
    @Value("${content}")
    private String content;

    //配置文件中的标签
    @Value("${student.s_name}")
    private String s_name;

    @Autowired
    private StudentProperties studentProperties;

    @RequestMapping("/json")
    public String json() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        
        String ret = "Welcome Spring Boot!<br/>name: "+name+"<br/>number: "+number+"<br/>"+content+"<br/><br/>"+"student属性：<br/>name: " + studentProperties.getS_name() + "<br/>age: " + studentProperties.getS_age() + "<br/>my_bean: " + ctx.getBean("my_message");
        ctx.close();
        return ret;
    }

    @RequestMapping("")
    public ModelAndView hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        m.addAttribute("name", s_name);
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }

}
