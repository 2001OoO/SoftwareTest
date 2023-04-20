<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/10
  Time: 5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>申请管理</title>
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
            <td>姓名</td>
            <td>地区</td>
            <td>组织</td>
        </tr>
        <c:forEach items="${applyList}" var="apply" varStatus="loop">
            <tr>
                <input type="hidden" value="${apply.id}" name="id">
                <td>${apply.username}</td>
                <td>${ascriptionList[loop.count-1]}</td>
                <td>${organizationList[loop.count-1]}</td>
                <td><a href="${pageContext.request.contextPath}/admin/acceptApply?id=${apply.id}">同意</a></td>
                <td><a href="${pageContext.request.contextPath}/admin/refuseApply?id=${apply.id}">拒绝</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
