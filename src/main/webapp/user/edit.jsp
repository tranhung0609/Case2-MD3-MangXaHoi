<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/3/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="hidden" name ="id" value="${user.id}" >
<input type="text" name ="full_name" value="${user.full_name}" placeholder="name">
<input type="email" name ="email" value="${user.email}" placeholder="email">
<input type="avtar" name ="avatar" value="${user.avatar}" placeholder="avatar">
<input type="text" name ="date_of_birth" value="${user.date_of_birth}" placeholder="date_birth">
<input type="password" name ="password" value="${password}" placeholder="pass">
    <button>Edit</button>
</form>
</body>
</html>
