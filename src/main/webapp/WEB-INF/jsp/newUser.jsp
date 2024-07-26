<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup - Flight Management System</title>
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

        function validatePassword() {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
            var errorMessage = document.getElementById('error-message');
            
            var passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,}$/;
            
            if (!passwordPattern.test(password)) {
                errorMessage.textContent = 'Password must be at least 5 characters long, contain one uppercase letter, one special character, and one numeric character.';
                return false;
            }
            
            if (password !== confirmPassword) {
                errorMessage.textContent = 'Password and Confirm Password do not match.';
                return false;
            }
            
            errorMessage.textContent = '';
            return true;
        }
    </script>
</head>
<body>
 <%@include file="Base.jsp" %>
   <div class="container">
        <div class="signup-box">
      
            <h2>SignUp</h2>
            <div id="error-message" class="error">${errorMessage}</div>
            <form action="newUser" method="post" onsubmit="return validatePassword()">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
                <br>
                <label for="userType">User Type:</label>
                <select id="userType" name="userType" required>
                    <option value="ROLE_CUSTOMER">Customer</option>
                    </select>
                <div class="show-password">
                    <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()">
                    <label for="showPassword">Show Password</label>
                </div>
                <input type="submit" value="Register">
            </form>
        </div>
    </div>
    
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
   
</body>
</html>