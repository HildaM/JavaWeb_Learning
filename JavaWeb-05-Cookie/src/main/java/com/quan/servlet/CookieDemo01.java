package com.quan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName: CookieDemo01
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/25 15:31
 */

// 保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-16");
        resp.setCharacterEncoding("UTF-16");
        PrintWriter out = resp.getWriter();

        // 服务器告诉你到来的时间，将这个时间封装为一个 Cookie（信件）
        // Cookie，服务器从客户端获取
        Cookie[] cookies = req.getCookies();   // 返回数组，说明cookie可能存在多个
            // 判断cookie是否为空
        if (cookies != null) {
            // 如果存在cookie
            out.write("上一次访问时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                String name = cookie.getName();
                if (name.equals("LastLoginTime")) {
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是你第一次访问！");
        }

        // 服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("LastLoginTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24*60*60);  // cookie有限期为1天
        // cookie.setMaxAge(0);  设置为0后，页面不会再保存cookie！！！
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
