<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/23
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑组织街道信息</title>
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
            <td>地区名称</td>
            <td>组织名称</td>
            <td></td>
        </tr>
        <c:forEach items="${organizationList}" var="organization" varStatus="loop">
            <tr>
                <input type="hidden" value="${organization.id}" name="id">
                <td>${organization.ascription}</td>
                <td>${organization.name}</td>
                <td><a href="${pageContext.request.contextPath}/admin/dropOrganization?id=${organization.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <form action="${pageContext.request.contextPath}/admin/addOrganization" method="post">
                <td>地区：<select name="ascription_name">
                    <c:forEach items="${ascriptionList}" var="ascription">
                        <option>${ascription.name}</option>
                    </c:forEach>
                </select></td>
                <td><input type="text" name="organization_name"></td>
                <td><input type="submit" value="添加"></td>
            </form>
        </tr>
    </table>
</div>
<input type="hidden" name="message" value="${message}" id="message">
</body>
</html>
<script type="text/javascript">
    window.onload=function checkForm(){
        var obj = document.getElementById("message");
        if(obj.value!=""){
            alert(obj.value)
        }
    }
</script>
