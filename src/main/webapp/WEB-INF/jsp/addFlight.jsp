<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Flight</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-between;
            height: 100vh;
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
            margin-top: 20px; /* Adjust margin as desired */
            padding-top: 10px;
            font-size: 28px; /* Increase font size */
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px; /* Adjust spacing from title */
        }

        label {
            font-weight: bold;
        }

        input[type="number"],
        input[type="text"],
        input[type="time"],
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

        .error-message,
        .success-message {
            color: white;
            padding: 10px;
            text-align: center;
            border-radius: 4px;
            margin-top: 10px;
            position: fixed;
            top: 10px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 1000;
            display: none; /* Initially hidden */
        }

        .error-message {
            background-color: #f44336; /* Red background for error messages */
        }

        .success-message {
            background-color: #4CAF50; /* Green background for success messages */
        }

        footer {
            text-align: center;
            margin-top: 20px;
            color: #666666;
            padding: 10px 0;
            background-color: #ffffff;
            width: 100%;
            box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.1);
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const successMessage = document.querySelector(".success-message");
            const errorMessage = document.querySelector(".error-message");

            if (successMessage) {
                successMessage.style.display = 'block';
                setTimeout(() => {
                    successMessage.style.display = 'none';
                }, 3000); 
            }

            if (errorMessage) {
                errorMessage.style.display = 'block';
                setTimeout(() => {
                    errorMessage.style.display = 'none';
                }, 2000); 
            }
        });
    </script>
</head>
<body>
    <h2>Add Flight</h2>
    <div class="container">
        <form action="${pageContext.request.contextPath}/addFlight" method="post">
            <div>
                <label for="flightNumber">Flight ID:</label>
                <input type="number" id="flightNumber" name="flightNumber" required>
            </div>
            <div>
                <label for="carrierName">Airlines Name:</label>
                <input type="text" id="carrierName" name="carrierName" required>
            </div>
            <div>
                <label for="routeId">Select Route ID:</label>
                <select id="routeId" name="routeId" required>
                    <c:forEach var="route" items="${routes}">
                        <option value="${route.routeId}">${route.routeId} (${route.sourceAirport} - ${route.destinationAirport})</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="seatCapacity">Seat Capacity:</label>
                <input type="number" id="seatCapacity" name="seatCapacity" required>
            </div>
            <div>
                <label for="departure">Departure Time:</label>
                <input type="time" id="departure" name="departure" required>
            </div>
            <div>
                <label for="arrival">Arrival Time:</label>
                <input type="time" id="arrival" name="arrival" required>
            </div>
            <h3>Return Flight Details</h3>
            <div>
                <label for="returnDeparture">Return Departure Time:</label>
                <input type="time" id="returnDeparture" name="returnDeparture" required>
            </div>
            <div>
                <label for="returnArrival">Return Arrival Time:</label>
                <input type="time" id="returnArrival" name="returnArrival" required>
            </div>
            <div>
                <button type="submit">Add Flight</button>
            </div>
        </form>
        <c:if test="${not empty successMessage}">
            <p class="success-message">${successMessage}</p>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
    </div>
    <button class="home-button" onclick="location.href='${pageContext.request.contextPath}/index'">Return to Home</button>
    <footer>Flight Management System @ Infosys Springboard</footer>
</body>
</html>
