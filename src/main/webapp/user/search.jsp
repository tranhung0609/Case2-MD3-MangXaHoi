<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/5/2022
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="list" var="user">
    <h1>${user.name}</h1>
</c:forEach>
</body>
</html>
