<%--
  Created by IntelliJ IDEA.
  User: Quan
  Date: 2021/10/24
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello JavaWeb</title>
  </head>
  <body>

  <h2>Hello Servlet</h2>

<%-- 这里提交的路径，需要寻找到项目的路径 --%>
  <form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"/><br>
    密码：<input type="text" name="password"/><br>
    <input type="submit">
  </form>


  </body>
</html>
