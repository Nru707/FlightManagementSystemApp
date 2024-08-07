<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
            <h2>ADMIN LOGIN</h2>
            <div class="error">${errorMessage}</div>
            <form action="login" method="post">
                <label for="username">UserName</label>
                <input type="username" id="username" name="username" required 
                    class="${not empty errorMessage ? 'input-error' : ''}">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required 
                    class="${not empty errorMessage ? 'input-error' : ''}">
                    <br><br>
                 <input type="submit" value="Login">
            </form>
            <!--  <div class="login-options">
                <a href="${pageContext.request.contextPath}/forgotPassword.jsp">Forgot Password?</a>
                <a href="${pageContext.request.contextPath}/newUser">Don't have an account? Create one</a>
            </div>
            -->
        </div>
    </div>
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
  
</body>
</html>
