<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Flight</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            min-height: 100vh;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 80%;
            max-width: 600px;
            margin-top: 20px;
        }

        h2 {
            text-align: center;
            color: #333333;
            margin-top: 0;
            padding-top: 10px;
            font-size: 24px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        label {
            font-weight: bold;
        }

        select {
            width: calc(100% - 20px);
            padding: 8px;
            font-size: 14px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        button[type="submit"],
        .home-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            margin: 10px auto;
        }

        button[type="submit"]:hover,
        .home-button:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            margin-top: 10px;
            text-align: center;
        }

        .success-message {
            color: green;
            margin-top: 10px;
            text-align: center;
        }

        footer {
            text-align: center;
            color: #666666;
            padding: 10px 0;
            background-color: #4CAF50;
            width: 100%;
            box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.1);
            position: fixed;
            bottom: 0;
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const successMessage = document.querySelector(".success-message");
            const errorMessage = document.querySelector(".error-message");

            if (successMessage) {
                setTimeout(() => {
                    successMessage.style.display = 'none';
                }, 5000); // Hide after 5 seconds
            }

            if (errorMessage) {
                setTimeout(() => {
                    errorMessage.style.display = 'none';
                }, 5000); // Hide after 5 seconds
            }
        });
    </script>
</head>
<body>
    <h2>Search Flight</h2>
    <div class="container">
        <form action="${pageContext.request.contextPath}/searchFlight" method="post">
            <div>
                <label for="fromCity">Select From City:</label>
                <select id="fromCity" name="fromCity" required>
                    <c:forEach var="airport" items="${airports}">
                        <option value="${airport.airportLocation}">${airport.airportLocation}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="toCity">Select To City:</label>
                <select id="toCity" name="toCity" required>
                    <c:forEach var="airport" items="${airports}">
                        <option value="${airport.airportLocation}">${airport.airportLocation}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit"onclick="location.href='${pageContext.request.contextPath}/searchFlightResult'">Search Flight</button>
            </div>
        </form>
        <button class="home-button" onclick="location.href='${pageContext.request.contextPath}/index'">Return</button>
    </div>
    <footer>Flight Management System @ Infosys Springboard</footer>
</body>
</html>
