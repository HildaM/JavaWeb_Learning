package com.quan.servlet;

import com.quan.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: LoginServlet
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/26 18:56
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端请求的参数
        String username = req.getParameter("username");

        // 判断信息
        if ("admin".equals(username)) {  // 登录成功
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());
            System.out.println(req.getSession().getId());
            resp.sendRedirect("/sys/success.jsp");
        } else {  // 登录失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
