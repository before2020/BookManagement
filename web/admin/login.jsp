<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>登录图书管理系统</title>

    <link rel="stylesheet" href="${ctx}/admin/css/login.css" type="text/css"/>

</head>
<body>
<div class="Login-background">

</div>
<div class="Login-main">
    <div class="title">图书管理系统</div>
    <form id="Login-form" action="${ctx}/LoginServlet" method="post">
        <div class="Input-wrapper">
            <input type="text" name="username" placeholder="用户名" class="Input"/>
        </div>
        <div class="Input-wrapper">
            <input type="password" name="password" placeholder="密码" class="Input"/>
        </div>
        <button id="Login-button">登录</button>

        <c:if test="${loginState eq 'fail'}">
            <div id="Fail-message">登录失败</div>
        </c:if>
    </form>
</div>
</body>

<script>

    $("#Login-button").click(function () {
        $("#Login-form").submit();
    });

</script>
</html>

