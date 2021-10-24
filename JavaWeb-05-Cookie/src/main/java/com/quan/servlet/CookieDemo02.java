package com.quan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName: CookieDemo02
 * @Description:  传递中文数据
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/25 16:21
 */
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-16");
        req.setCharacterEncoding("UTF-16");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("name")) {
//                    String value = cookies[i].getValue();
                    // 解码
                    String value = URLDecoder.decode(cookies[i].getValue());
                    out.write(value);
                }
            }
        } else {
            out.write("第一次访问");
        }

        // 编码 URLEncoder.encode("权", "utf-8")
        Cookie cookie = new Cookie("name", URLEncoder.encode("权", "utf-8"));
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
