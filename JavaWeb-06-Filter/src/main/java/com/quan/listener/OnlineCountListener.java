package com.quan.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName: OnlineCountListener
 * @Description:   统计网站在线人数（监听）----> 统计Session
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/26 10:30
 */
public class OnlineCountListener implements HttpSessionListener {
    // 创建Session监听
    // 一旦创建Session，就会出发一次这个事件
    // 观察者模式
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();

        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        // 探究为什么显示有 3 人在线
        System.out.println(se.getSession().getId());

        if (onlineCount == null) {
            onlineCount = new Integer(1);
            // onlineCount = 1;
        }
        else {
            int count = onlineCount.intValue();
            // int count = onlineCount;
            onlineCount = new Integer(count + 1);
            // onlineCount = count + 1;
        }

        ctx.setAttribute("OnlineCount", onlineCount);
    }

    // 销毁Session监听
    // 一旦Session销毁，就会出发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();

        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        // 反向操作
        if (onlineCount == null) {
            onlineCount = new Integer(0);
            // onlineCount = 1;
        }
        else {
            int count = onlineCount.intValue();
            // int count = onlineCount;
            onlineCount = new Integer(count - 1);
            // onlineCount = count + 1;
        }

        ctx.setAttribute("OnlineCount", onlineCount);
    }
}
