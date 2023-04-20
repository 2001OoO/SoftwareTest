<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/9
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>管理员信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_details_style.css">
</head>
<body>
<div class="zuo">
    <a href="${pageContext.request.contextPath}/admin/toAdminInfo">我的信息</a>
    <a href="${pageContext.request.contextPath}/admin/toApplyManagement">申请管理</a>
    <a href="${pageContext.request.contextPath}/admin/toAdminDetails">党员信息管理</a>
    <a href="${pageContext.request.contextPath}/admin/toEditRegion">组织地区管理</a>
    <a href="${pageContext.request.contextPath}/admin/toEditOrganization">组织街道管理</a>
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
