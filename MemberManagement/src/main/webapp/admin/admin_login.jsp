<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/23
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
</head>
<body>
<h1>管理员登录</h1>
<form action="${pageContext.request.contextPath}/loginAdmin" method="post">
    <div class="text1">
        编号：<input type="text" name="number"><br />
    </div>
    <div class="text2">
        密码：<input type="password" name="password"><br />
    </div>
    <div class="button">
        <input type="submit" value="登录">
    </div>
    <div class="text4">
        <a href="${pageContext.request.contextPath}/toLogin">用户登录</a>
    </div>
    <input type="hidden" name="message" id="message" value="${message}">
</form>
</body>
</html>
<script>
    let message = $("#message").val();
    if(message!=null){
        layer.msg(message);
    }
</script>
