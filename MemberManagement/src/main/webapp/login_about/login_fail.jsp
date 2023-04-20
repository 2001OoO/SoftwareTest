<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/6
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
</head>
<body>
<h1>登录失败！！！</h1>
<h3 class="text3">${messages}</h3>
<div class="text5">
    <a href="${pageContext.request.contextPath}/toLogin" method="post">返回登录</a>
</div>
</body>
</html>
