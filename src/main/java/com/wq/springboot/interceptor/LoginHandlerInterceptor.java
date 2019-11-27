package com.wq.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
最简单明了的区别就是过滤器可以修改request，而拦截器不能
过滤器需要在servlet容器中实现，拦截器可以适用于javaEE，javaSE等各种环境
拦截器可以调用IOC容器中的各种依赖，而过滤器不能
过滤器只能在请求的前后使用，而拦截器可以详细到每个方法
 */
/**
 * 登陆拦截器
 * 场景：用户点击查看的时候，我们进行登陆拦截器操作，判断用户是否登陆？
 * 登陆，则不拦截，没登陆，则转到登陆界面；
 *
 * 在一个工程中，可以配置多个拦截器，使用多个拦截器，则要注意的是 ：
 * 多个拦截器使用的时候，preHandler是顺序执行的，而postHandler和afterHandler是倒序执行的；
 * 所以 ：
 * 如果统一日志处理器拦截器，需要改拦截器prehandler一定要返回true，且将它放在拦截器配置的第一个位置；
 * 如果登陆认证拦截器，放在拦截器的配置中的第一个位置（有日志处理的话，放在日志处理下面）；
 * 如果有权限校验拦截器，则放在登陆拦截器之后，因为登陆通过后，才可以进行校验权限；
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //afterHandler: 在执行Handler完成后执行此方法，使用于统一的异常处理，统一的日志处理等；
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object arg2, Exception arg3)
            throws Exception {
    }

    //postHandler : 进入Handler方法之后，返回ModelAndView之前执行，使用场景从ModelAndView参数出发，比如，将公用的模型数据在这里传入到视图，也可以统一指定显示的视图等；
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object arg2, ModelAndView arg3)
            throws Exception {
    }

    //preHandler ：在进入Handler方法之前执行了，使用于身份认证，身份授权，登陆校验等，比如身份认证，用户没有登陆，拦截不再向下执行，返回值为false ，即可实现拦截；否则，返回true时，拦截不进行执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object arg2)
            throws Exception {
        //String requestURI = request.getRequestURI();
        String url = request.getRequestURI().substring(request.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        System.out.println("拦截器实现=>"+url);
        if(isInclude(url))
            return true;
        //拦截非公共模块的uri
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username!=null){
            //登陆成功的用户
            return true;
        }else{
            //没有登陆，转向登陆界面
//                request.getRequestDispatcher("/user/login.jsp").forward(request,arg1);
//                return false;
            System.out.println("需要登录，拦截器不放行！");
//                response.sendRedirect("/user/login");
//                return false;
            return true;
        }
    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        List<Pattern> patterns = new ArrayList<Pattern>();
        patterns.add(Pattern.compile("error"));
        patterns.add(Pattern.compile("user/login"));
        patterns.add(Pattern.compile("user/logout"));
        patterns.add(Pattern.compile(".*public_.*"));
        patterns.add(Pattern.compile("static/.*"));
        patterns.add(Pattern.compile(".*(.css|.png|.js|.jpg|.jpeg|.gif|.ico)$"));
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}
