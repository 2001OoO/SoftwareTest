<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/9
  Time: 12:19
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
    <a href="${pageContext.request.contextPath}/user/toUserInfo">我的信息</a>
    <a href="${pageContext.request.contextPath}/user/toUpdateUserInfo">信息修改</a>
    <a href="${pageContext.request.contextPath}/quitLogin">退出登录</a>
</div>
<div class="you">
    <form action="${pageContext.request.contextPath}/user/updateUserInfo" method="post">
        编号：${UserSession.number}<br />
        姓名：<input name="username" value="${UserSession.username}"><br />
        密码：<input name="password" value="${UserSession.password}"><br />
        地区：<select id="ascription" name="ascription_name" onclick="getlist()">
        <c:forEach items="${AscriptionList}" var="ascription">
            <option>${ascription}</option>
        </c:forEach>
    </select><br />
        组织：<select id="organization" name="organization_name"></select><br />
        注册时间：${UserSession.register_time}<br />
        权限：${jurisdiction}<br />
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
