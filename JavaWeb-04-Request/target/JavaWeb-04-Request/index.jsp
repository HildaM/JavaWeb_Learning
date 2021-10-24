<%--
  Created by IntelliJ IDEA.
  User: Quan
  Date: 2021/10/25
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1 style="text-align: center">登录页面</h1>

    <div style="text-align: center">
        <%--    以 post 方式提交表单，提交到login请求   --%>
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名：<input type="text" name="username"><br>
            密码： <input type="password" name="password"><br>

            爱好：
            <input type="checkbox" name="hobbies" value="女孩">女孩
            <input type="checkbox" name="hobbies" value="代码">代码
            <input type="checkbox" name="hobbies" value="谈心">谈心
            <input type="checkbox" name="hobbies" value="郊游">郊游
            <br>
            <input type="submit">
        </form>
    </div>

</body>
</html>
