package com.quan.servlet;

import com.quan.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName: SessionDemo01
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/25 19:08
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到Session
        HttpSession session = req.getSession();

        // 往Session中存东西
        session.setAttribute("username", "Hilda_quan");
        session.setAttribute("personName", new Person("Quan", 18));

        // 获取Session的id
        String sessionid = session.getId();

        // 判断Session是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，id：" + sessionid);
        } else {
            resp.getWriter().write("Session已存在！");
        }


        // Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSESSIONID", sessionid);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
