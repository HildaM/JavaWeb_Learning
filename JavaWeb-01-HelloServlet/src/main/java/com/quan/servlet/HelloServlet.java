package com.quan.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: HelloServlet
 * @Description: 第一个Servlet程序
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/23 14:27
 */
public class HelloServlet extends HttpServlet {

    // 由于 get 或者 post 只是请求实现的不同方式，可以相互调用，因为业务逻辑都一样

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了 doGet 方法");

        // 响应流
        PrintWriter writer = resp.getWriter();

        writer.print("Hello Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
