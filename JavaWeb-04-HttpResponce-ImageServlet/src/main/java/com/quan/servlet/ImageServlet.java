package com.quan.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: ImageServlet
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2021/10/24 15:59
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让浏览器 3 秒自动刷新一次
        resp.setHeader("refresh", "3");

        // 在内存中创建图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);

        // 得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();   // 一支“笔”
        // 设置图片背景颜色
        graphics.setBackground(Color.lightGray);
        graphics.fillRect(0, 0, 80, 20);

        // 给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("SansSerif", Font.BOLD, 20));
        graphics.drawString(makeNum(), 0, 20);


        // 告诉浏览器用图片的方式打开
        resp.setContentType("image/png");

        // 网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 把图片写给浏览器
        ImageIO.write(image, "png", resp.getOutputStream());

    }

    // 生成随机数
    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(99999999) + "";  // 生成 8 位随机数

        // 上面生成的随机数，有可能达不到 8 位数
        // 此时，使用一个for循环对可能出现的空缺进行补足！！！
        // 7 - num.length()：确保补全到 8 位数为止！！！
        StringBuffer stringBuffer = new StringBuffer(num);
        for (int i = 0; i < 7 - num.length(); i++) {
            stringBuffer.append("0");
        }
        String res = stringBuffer.toString() + num;
        return res;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
