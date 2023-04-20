<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/5
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/loginUser" method="post">
    <div class="text1">
        编号：<input type="text" name="number"><br />
    </div>
    <div class="text2">
        密码：<input type="password" name="password"><br />
    </div>
    <div class="button">
        <input type="submit" value="登录">
    </div>
    <div class="text3">
        <a href="${pageContext.request.contextPath}/toRegister" method="post">申请成为党员</a>
    </div>
    <div class="text5">
        <a href="${pageContext.request.contextPath}/toLoginAdmin" method="post">管理员登录</a>
    </div>
</form>
</body>
</html>

