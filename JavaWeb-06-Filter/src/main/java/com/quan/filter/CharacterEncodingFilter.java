package com.quan.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: CharacterEncodingFilter
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/26 9:54
 */
public class CharacterEncodingFilter implements Filter {
    // 初始化：web服务器启动就执行初始化，以便随时等待过滤对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter 已经初始化");
    }

    // chain
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前.....");
        chain.doFilter(request, response);   // 让我们的请求继续执行，如果不写，程序到这里就会停止执行了
        System.out.println("CharacterEncodingFilter 执行后.....");

    }

    // 销毁：在web服务器关闭的时候，过滤器就会销毁
    @Override
    public void destroy() {
        // System.gc();
        System.out.println("CharacterEncodingFilter 已经销毁");
    }
}
