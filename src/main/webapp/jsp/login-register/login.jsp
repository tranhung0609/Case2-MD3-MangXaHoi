<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/30/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
</head>
<body>
<h2>Sign in/up Form</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="/users?action=register" method="post">
            <h1>Create Account</h1>
            <%--      <div class="social-container">--%>
            <%--        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>--%>
            <%--        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>--%>
            <%--        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>--%>
            <%--      </div>--%>
            <%--      <span>or use your email for registration</span>--%>
            <input type="text" placeholder="FullName" name="full_name"/>
            <input type="date" placeholder="Date-of-birth" name="date_of_birth"/>
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <button>Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="/users?action=login" method="post">
            <h1>Sign in</h1>
            <%--      <div class="social-container">--%>
            <%--        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>--%>
            <%--        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>--%>
            <%--        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>--%>
            <%--      </div>--%>
            <%--      <span>or use your account</span>--%>
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <a href="#">Forgot your password?</a>
            <button>Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../../js/login.js"></script>
</html>