<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>图书管理系统</title>
    <frameset rows="25%, 75%">
        <frame src="${ctx}/admin/header.jsp" frameborder="0"/>
        <frame src="${ctx}/BookServlet?action=getBookList" frameborder="border"/>
    </frameset>
</head>
<body>

</body>
</html>
