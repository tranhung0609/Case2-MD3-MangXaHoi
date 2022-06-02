<%--
  Created by IntelliJ IDEA.
  User: chuon
  Date: 6/2/2022
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${post}" var="pos">
   <h1>${pos.content},${pos.time}</h1>
    <img src="${pos.image}">
</c:forEach>
</body>
</html>
