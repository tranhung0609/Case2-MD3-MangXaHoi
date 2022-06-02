<%--
  Created by IntelliJ IDEA.
  User: chuon
  Date: 6/2/2022
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="comm" items="${comment}">
    <h1>${comm.time},${comm.user.fullName}</h1>
</c:forEach>
</body>
</html>
