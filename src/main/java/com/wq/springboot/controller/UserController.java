package com.wq.springboot.controller;

import com.wq.springboot.common.json.CallResult;
import com.wq.springboot.entity.AcctUser;
import com.wq.springboot.mapper.MyUserMapper;
import com.wq.springboot.service.IMyUserService;
import com.wq.springboot.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //将log4j.properties放到classpath目录下即可有日志
    private Logger LOGGER = Logger.getLogger(this.getClass());

    //Autowired这个annotation，它是为了告诉spring，这个对象没有实例化，需要注入一个IUserService的实例
    //可是问题是，IUserSerivce是一个接口，如果不指定就不知道你想用哪个实现类，Spring会首先看自己的容器里有没有一个叫做userService的对象（刚才创建的UserServiceImpl的对象名字就叫做userServiceImpl），如果找不到就在配置文件里配置的路径下面寻找UserService的实现类，找到了就把它的对象拿过来.除此之外刚才Service那个annotation还可以指定一个value：@Service("userService")。这样一来，对于UserServiceImpl这个类的实例，Spring给它起的名字就不是userServiceImpl了，而是userService，如果某个接口的实现类有多个，就可以使用这种方法来指定用哪个实现类，个人认为，如果每个接口都只有一个实现类，那么这么做确实很方便，但如果有多个实现类并且可能会更换的话，就不如配置文件明了了。
    @Autowired
    private IUserService userService;       //测试使用

    //正式使用 userMapper和myUserService
    @Autowired
    private MyUserMapper userMapper;
    @Autowired
    private IMyUserService myUserService;

    @ResponseBody
    @RequestMapping("/users/json")
    public CallResult json(){
        LOGGER.info("查询用户全部用户");

        CallResult cr = new CallResult(true);
        cr.setData(userService.findAll());
        return cr;
    }

    @RequestMapping("/users")
    public String users(Model model){
        //List<AcctUser> userList = userService.findAll();
        List<AcctUser> userList = myUserService.getAllList(userMapper, null);
        model.addAttribute("userList", userList);
        return "/user/users";
    }

    @RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
    public String userInfo(Model model, @PathVariable String userId){
        //AcctUser userInfo = userService.get(userId);
        AcctUser userInfo = myUserService.getById(userMapper, userId);
        if(userInfo != null){
            model.addAttribute("userInfo", userInfo);
            return "/user/userinfo";
        }
        // return this.users(model);       //转到列表中
        model.addAttribute("errorMsg", "没有对应的用户编号！");
        return "/error/error";
    }

    @ResponseBody
    @RequestMapping(value = "/id/{id}/json", method = RequestMethod.GET)
    public CallResult userinfo_json(@PathVariable String id){
        AcctUser userInfo = userService.get(id);
        CallResult cr = new CallResult(true);
        cr.setData(userInfo);
        return cr;
    }

    @Value("${name}")
    private String name;
    @Value("${number}")
    private Integer number;
    @Value("${content}")
    private String content;
    @RequestMapping("/public_hello")
    public ModelAndView hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        m.addAttribute("name", content);
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "test");
        return "假装这是登录页面";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        //getSession参数为true时表示没有session生成之
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.getServletContext().removeAttribute("name");
            session.invalidate();
            return "假装这是登出页面（清空session）";
        }
        return "假装这是登出页面";
    }

    @ResponseBody
    @RequestMapping("/blogs")
    public String blogs(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            Object name=session.getAttribute("name");
            Object count=session.getServletContext().getAttribute("count");
            return "Blogs页面。name: "+name+ " | count: " + count;
        }
        return "Blogs页面";
    }
}
