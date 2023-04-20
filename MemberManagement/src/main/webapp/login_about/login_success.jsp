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
    <title>登录成功</title>
</head>
<body>
<h1>登录成功！！！</h1>
<h4>欢迎：${UserSession.username}</h4>
<li><a href="${pageContext.request.contextPath}/quitLogin">退出登录</a></li>
</body>
</html>
