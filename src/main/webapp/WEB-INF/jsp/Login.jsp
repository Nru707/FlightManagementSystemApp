<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Login - Flight Management System</title>
    <style>
     <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <script>
        function togglePasswordVisibility() {
            var passwordField = document.getElementById('password');
            var confirmPasswordField = document.getElementById('confirmPassword');
            var showPasswordCheckbox = document.getElementById('showPassword');
            
            if (showPasswordCheckbox.checked) {
                passwordField.type = 'text';
                confirmPasswordField.type = 'text';
            } else {
                passwordField.type = 'password';
                confirmPasswordField.type = 'password';
            }
        }
        </script>
</head>
<body>
<%@include file="Base.jsp" %>
    <div class="container">
        <div class="login-box">
            <h2>Login</h2>
            <div class="error">${errorMessage}</div>
            <form:form action="/Login" method="post">
                <label for="email">Email:</label>
                <input type="email"  name="username" required 
                    class="${not empty errorMessage ? 'input-error' : ''}">
                <label for="password">Password:</label>
                <input type="password"  name="password" required 
                    class="${not empty errorMessage ? 'input-error' : ''}">
                    <br><br>
                 <input class="bg-primary" type="submit" herf="/user/userindex"value="Login">
            </form:form >
            <br>
            <div class="login-options text-center">
                <a href="${pageContext.request.contextPath}/newUser">Don't have an account? Create one</a>
            </div>
        </div>
    </div>
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
  
</body>
</html>
