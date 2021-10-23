package com.quan.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @ClassName: FileServlet
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/24 14:59
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/66255236_p0.jpg");
        System.out.println("下载文件的路径：" + realPath);

        // 2. 获取下载文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

        // 3. 设置浏览器支持下载（Content-Disposition）
        // URLEncoder.encode(fileName, "UTF-8")：让中文文件名可以正常显示
        resp.setHeader("Content-Disposition",  "attachment;filename=" +
                URLEncoder.encode(fileName, "UTF-8"));

        // 4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);

        // 5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];

        // 6. 获取 OutputStream 对象
        ServletOutputStream outputStream = resp.getOutputStream();

        // 7. 将 FileOutputStream 流写到 Buffer 缓冲区中
        // 8. 用 OutputStream 将缓冲区数据输出到浏览器中
        while ((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        outputStream.close();
        in.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
