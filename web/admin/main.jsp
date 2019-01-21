<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>图书管理系统</title>
    <link rel="stylesheet" href="${ctx}/admin/css/main.css" type="text/css"/>
</head>
<body>
<div class="Table-wrapper" align="center">
    <table class="Table">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>出版社</th>
            <th>类别</th>
            <th>年份</th>
            <th>售价</th>
        </tr>

        <c:forEach items="${bookList}" var="book">
            <div ></div>
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.press}</td>
                <td>${book.category}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td><a href="${ctx}/BookServlet?action=updatePage&bid=${book.bid}">编辑</a></td>
                <td><a href="${ctx}/BookServlet?action=delete&bid=${book.bid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>

</html>
