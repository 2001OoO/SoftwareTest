<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/23
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑组织地区信息</title>
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
            <td></td>
        </tr>
        <c:forEach items="${ascriptionList}" var="ascription" varStatus="loop">
            <tr>
                <td>${ascription.name}</td>
                <td><a href="${pageContext.request.contextPath}/admin/dropRegion?name=${ascription.name}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <form action="${pageContext.request.contextPath}/admin/addRegion" method="post">
                <td><input type="text" name="name"></td>
                <td><input type="submit" value="添加"></td>
            </form>
        </tr>
    </table>
</div>
</body>
<input type="hidden" name="message" value="${message}" id="message">
</html>
<script type="text/javascript">
    window.onload=function checkForm(){
        var obj = document.getElementById("message");
        if(obj.value!=""){
            alert(obj.value)
        }
    }
</script>