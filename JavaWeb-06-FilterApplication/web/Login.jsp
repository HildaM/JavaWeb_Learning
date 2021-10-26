<%--
  Created by IntelliJ IDEA.
  User: Quan
  Date: 2021/10/26
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h1>登录</h1>
    <form action="/servlet/login" method="post">
        <input type="text" name="username">
        <input type="submit">
    </form>
</body>
</html>
