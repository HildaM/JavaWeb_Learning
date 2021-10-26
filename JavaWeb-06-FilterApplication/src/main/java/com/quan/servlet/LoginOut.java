package com.quan.servlet;

import com.quan.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: LoginOut
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/26 19:14
 */
public class LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user_Session = req.getSession().getAttribute(Constant.USER_SESSION);

        if (user_Session != null) {
            req.removeAttribute(Constant.USER_SESSION);
        }

        resp.sendRedirect("/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
