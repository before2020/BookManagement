<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>编辑图书-图书管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/edit.css">
</head>
<body>
<div id="main">
    <form action="${pageContext.request.contextPath}/BookServlet?action=update" method="post">
        <div style="display: none">
            <input name="bid" type="text" value="${book.bid}">
        </div>
        <div class="item">
            <span>书名：</span><input name="title" type="text" value="${book.title}">
        </div>
        <div class="item">
            <span>作者：</span><input name="author" type="text" value="${book.author}">
        </div>
        <div class="item">
            <span>出版社：</span><input name="press" type="text" value="${book.press}">
        </div>
        <div class="item">
            <span>类别：</span><input name="category" type="text" value="${book.category}">
        </div>
        <div class="item">
            <span>日期：</span><input name="date" type="text" value="${book.date}">
        </div>
        <div class="item">
            <span>售价：</span><input name="price" type="text" value="${book.price}">
        </div>
        <div class="submit-wrapper">
            <input type="submit" value="确认修改">
        </div>
    </form>

</div>
</body>
</html>
