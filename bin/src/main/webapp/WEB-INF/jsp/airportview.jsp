<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Airport</title>
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
        .search-form {
            margin-bottom: 20px;
        }
        .search-form input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .search-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .search-form input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
        .airport-details {
            margin-top: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
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
    </style>
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>View Airport</h2>
            <form class="search-form" action="<c:url value='/searchAirport' />" method="get">
                <label for="code">Airport Code:</label>
                <input type="text" id="code" name="code" placeholder="Enter Airport Code" required>
                <input type="submit" value="Search">
            </form>
            <c:if test="${not empty errorMessage}">
                <div class="error">${errorMessage}</div>
            </c:if>
            <c:if test="${not empty airportview}">
                <div class="airport-details">
                    <p><strong>Airport Code:</strong> <c:out value="${airportview.airportCode}" /></p>
                    <p><strong>Airport Location:</strong> <c:out value="${airportview.airportLocation}" /></p>
                </div>
            </c:if>
        </div>
        <a href="index" class="return-button">Return</a>
    </div>
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>
