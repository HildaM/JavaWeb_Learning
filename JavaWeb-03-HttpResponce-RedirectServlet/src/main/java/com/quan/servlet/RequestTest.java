package com.quan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: RequestTest
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/24 19:45
 */
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入该请求");

        // 处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // resp.getWriter().write(username + ": " + password);   // 输出到网页上
        System.out.println(username + ": " + password);         // 输出到控制台

        resp.sendRedirect("/s5/success.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
