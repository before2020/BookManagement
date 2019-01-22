<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/admin/css/header.css" type="text/css"/>

</head>
<body>
    <div id="main">
        <div class="title">
            图书管理系统
        </div>
        <div class="choice">
            <div class="show">
                <a href="${ctx}/BookServlet?action=getBookList" target="main_view">显示全部</a>
            </div>
            <div class="add">
                <a href="${ctx}/BookServlet?action=addPage" target="main_view">新增图书</a>
            </div>
        </div>
    </div>
</body>

</html>
