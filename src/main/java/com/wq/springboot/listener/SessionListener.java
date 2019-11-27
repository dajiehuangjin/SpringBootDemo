package com.wq.springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("监听sessionCreated");
        ServletContext context = arg0.getSession().getServletContext();
        if (context.getAttribute("count")==null) {
            context.setAttribute("count", 1);
        }else {
            int count = (Integer) context.getAttribute("count");
            context.setAttribute("count", count+1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("监听sessionDestroyed！");
        ServletContext context = arg0.getSession().getServletContext();
        if (context.getAttribute("count")==null) {
            context.setAttribute("count", 0);
        }else {
            int count = (Integer) context.getAttribute("count");
            if (count<1) {
                count = 1;
            }
            context.setAttribute("count", count-1);
        }
    }
}
