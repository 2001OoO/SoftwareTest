<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/10
  Time: 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>信息修改</title>
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
<form action="${pageContext.request.contextPath}/admin/adminUpdateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    编号：${user.number}<input type="hidden" readonly="readonly" value="${user.number}" name="number"/><br />
    姓名：<input name="username" value="${user.username}"><br />
    密码：<input name="password" value="${user.password}"><br />
    地区：<select id="ascription" name="ascription_name" onclick="getlist()">
    <c:forEach items="${ascriptionList}" var="ascription">
        <option>${ascription.name}</option>
    </c:forEach>
</select><br />
    组织：<select id="organization" name="organization_name"></select><br />
    注册时间：${user.register_time}<input type="hidden" readonly="readonly" value="${user.register_time}" name="register_time"/><br />
    权限：<select id="jurisdictionSelect" name="jurisdiction_name">
    <c:forEach items="${jurisdictionList}" var="jurisdiction">
        <option>${jurisdiction.name}</option>
    </c:forEach>
</select><br />
    <input type="submit" value="修改">
</form>
</div>
</body>
<script>
    window.onload=function setvalue(){
        var obj1=document.getElementById("ascription")
        for(var i=0;i<obj1.options.length;i++){
            if(obj1[i].value=="${ascription}"){
                obj1[i].selected = true;
            }
        }
        getlist();
        var obj2=document.getElementById("organization")
        for(var i=0;i<obj2.options.length;i++){
            if(obj2[i].value=="${organization}"){
                obj2[i].selected = true;
            }
        }
        var obj3=document.getElementById("jurisdictionSelect")
        for(var i=0;i<obj3.options.length;i++){
            if(obj3[i].value=="${jurisdiction}"){
                obj3[i].selected = true;
            }
        }
    }

    function getlist(){
        var obj = document.getElementById("organization");
        obj.innerHTML = "";
        // obj.options.length=0;
        var myselect = document.getElementById("ascription");
        var index=myselect.selectedIndex;
        var select = myselect.options[index].value;
        var list = new Array();
        var list2 = new Array();
        <c:forEach items="${organizations}" var="o">
        list.push("${o}");
        </c:forEach>
        <c:forEach items="${ascriptions}" var="a">
        list2.push("${a}");
        </c:forEach>
        var clist = new Array();
        for(var i=0;i<list2.length;i++) {
            if(list2[i]==select){
                obj.options.add(new Option(list[i]),i);
            }
        }
    }
</script>
</html>