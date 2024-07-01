<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Airport</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        .form-box {
            width: 320px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        .form-box h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .form-box label {
            display: block;
            margin-bottom: 5px;
        }
        .form-box input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-box input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-box input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
        .success {
            color: green;
            margin-bottom: 10px;
        }
        .return-button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            text-align: center;
        }
        .return-button:hover {
            background-color: #45a049;
        }
        footer {
            text-align: center;
            padding: 10px;
            background-color: #f1f1f1;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        #successMessage {
            display: none;
            color: green;
        }
    </style>
    <script>
        window.onload = function() {
            var success = '<c:out value="${success}" />';
            if (success === 'true') {
                document.getElementById('successMessage').style.display = 'block';
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Add Airport</h2>
            <div id="successMessage">Airport added successfully!</div>
            <c:if test="${not empty errorMessage}">
                <div class="error">${errorMessage}</div>
            </c:if>
            <form action="<c:url value='/addAirport' />" method="post">
                <label for="airportCode">Airport Code:</label>
                <input type="text" id="airportCode" name="airportCode" required>
                <label for="airportLocation">Airport Location:</label>
                <input type="text" id="airportLocation" name="airportLocation" required>
                <input type="submit" value="Add Airport">
            </form>
        </div>
        <a href="index" class="return-button">Return</a>
    </div>
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>
