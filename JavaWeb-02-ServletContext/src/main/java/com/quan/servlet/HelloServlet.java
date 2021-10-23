package com.quan.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: HelloServlet
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/23 16:23
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        String username = "Hilda_quan";
        context.setAttribute("username", username);  // 将一个数据保存在ServletContext中（key-value键值对）

        System.out.println("hello Servlet");
    }
}
