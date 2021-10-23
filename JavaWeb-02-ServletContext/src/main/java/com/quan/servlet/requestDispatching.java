package com.quan.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: requestDispatching
 * @Description: 使用context实现请求转发功能
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/23 19:21
 */
public class requestDispatching extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");  // 转发的请求路径
        requestDispatcher.forward(req, resp);   // 调用forward方法实现请求转发

        // 合二为一：context.getRequestDispatcher("/gp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
