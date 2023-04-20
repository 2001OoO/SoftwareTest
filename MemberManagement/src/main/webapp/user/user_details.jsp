<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/6
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_details_style.css">
</head>
<body>
<div class="zuo">
    <a href="${pageContext.request.contextPath}/user/toUserInfo">我的信息</a>
    <a href="${pageContext.request.contextPath}/user/toUpdateUserInfo">信息修改</a>
    <a href="${pageContext.request.contextPath}/quitLogin">退出登录</a>
</div>
<div class="you">
    <div>欢迎使用党员信息管理系统！</div>
    <li>账号：${UserSession.number}</li>
    <li>用户名：${UserSession.username}</li>
    <li>地区：${ascription}</li>
    <li>组织：${organization}</li>
    <li>注册时间：${UserSession.register_time}</li>
    <li>权限：${jurisdiction}</li>
</div>
</body>
</html>
