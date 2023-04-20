<%--
  Created by IntelliJ IDEA.
  User: 2001
  Date: 2022/12/5
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/registerUser" method="post">
    <div class="text0"><h2>申请成为党员！</h2></div>
    <div class="text1">
        姓名:<input type="text" name="username" id="username" onkeyup="checkusername()">
    </div>
    <div class="text2">
        密码:<input type="password" name="password" id="pw" onkeyup="checkpassword()">
    </div>
    <div class="text4">
        请再输入一次密码:<input type="password" name="password2" id="repw" onkeyup="checkpassword()"><span id="tishi"></span></input>
    </div>
    <div class="text3">
        地区：<select id="ascription" name="ascription_name" onclick="getlist()">
        <c:forEach items="${AscriptionList}" var="ascription">
            <option>${ascription}</option>
        </c:forEach>
    </select>
    </div>
    <div class="text5">
        党组织：<select id="organization" name="organization_name"></select>
    </div>
    <div class="text6">
        <input type="submit" value="申请" id="submit">
    </div>
    <div class="text7">
        <a href="${pageContext.request.contextPath}/toLogin">用户登录</a>
    </div>
</form>
</body>
<script>
    window.onload=function setvalue(){
        var obj1=document.getElementById("ascription");
        obj1[0].selected = true;

        getlist();
        var obj2=document.getElementById("organization");
        obj2[0].selected = true;

        document.getElementById("submit").disabled = true;
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
        <c:forEach items="${organization}" var="o">
        list.push("${o}");
        </c:forEach>
        <c:forEach items="${ascription}" var="a">
        list2.push("${a}");
        </c:forEach>
        var clist = new Array();
        for(var i=0;i<list2.length;i++) {
            if(list2[i]==select){
                obj.options.add(new Option(list[i]),i);
            }
        }
    }

    function checkusername() {
        var username = document.getElementById("username").value;
        if (username == "" || username == null){
            document.getElementById("submit").disabled = true;
        }else {
            document.getElementById("submit").disabled = false;
        }
    }

    function checkpassword() {
        var password = document.getElementById("pw").value;
        var repassword = document.getElementById("repw").value;

        if(password == repassword) {
            document.getElementById("tishi").innerHTML="<br><font color='green'>两次密码输入一致</font>";
            document.getElementById("submit").disabled = true;

        }else {
            document.getElementById("tishi").innerHTML="<br><font color='red'>两次输入密码不一致!</font>";
            document.getElementById("submit").disabled = false;
        }
        checkusername();
    }
</script>
</html>
