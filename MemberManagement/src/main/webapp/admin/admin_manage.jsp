<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/23
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>党员信息管理</title>
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
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>注册时间</td>
            <td>地区</td>
            <td>组织</td>
            <td>权限</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="loop">
            <tr>
                <td>${user.number}</td>
                <td>${user.username}</td>
                <td>${user.register_time}</td>
                <td>${ascriptionList[loop.count-1]}</td>
                <td>${organizationList[loop.count-1]}</td>
                <td>${jurisdictionList[loop.count-1]}</td>
                <td><a href="${pageContext.request.contextPath}/admin/toAdminUpdateUser?id=${user.id}">编辑信息</a></td>
                <td><a href="${pageContext.request.contextPath}/admin/dropUser?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
