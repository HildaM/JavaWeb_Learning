package com.quan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: com.quan.servlet.RedirectServlet
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/24 19:12
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Location", "/s5/randomNum");
//        resp.setStatus(302);
        resp.sendRedirect("/s5/randomNum");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
