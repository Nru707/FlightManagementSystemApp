<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Flight Result</title>
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
            max-width: 800px;
            margin-top: 20px;
        }

        h2 {
            text-align: center;
            color: #333333;
            margin-top: 0;
            padding-top: 10px;
            font-size: 24px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #dddddd;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        button.book-flight {
            background-color: #4CAF50;
            color: white;
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button.book-flight:hover {
            background-color: #45a049;
        }

        .fare-info {
            text-align: center;
            font-size: 18px;
            color: #555555;
            margin-top: 10px;
        }

        .no-flights {
            text-align: center;
            font-size: 18px;
            color: red;
            margin-top: 20px;
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
</head>
<body>
    <h2>The Flights in the route: ${fromCity} -----> ${toCity}</h2>
    <div class="container">
        <div class="fare-info">
            Air Fare: ${airFare}
        </div>
        <c:choose>
            <c:when test="${not empty flights}">
                <table>
                    <thead>
                        <tr>
                            <th>Flight Number</th>
                            <th>Carrier Name</th>
                            <th>Seat Capacity</th>
                            <th>Route ID</th>
                            <th>Arrival</th>
                            <th>Departure</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="flight" items="${flights}">
                            <tr>
                                <td>${flight.flightNumber}</td>
                                <td>${flight.carrierName}</td>
                                <td>${flight.seatCapacity}</td>
                                <td>${flight.routeId}</td>
                                <td>${flight.arrival}</td>
                                <td>${flight.departure}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/bookFlight" method="post">
                                        <input type="hidden" name="flightNumber" value="${flight.flightNumber}">
                                        <input type="hidden" name="carrierName" value="${flight.carrierName}">
                                        <button type="submit" class="book-flight">Book Flight</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-flights">
                    No flights available for the selected route.
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <footer>Flight Management System @ Infosys Springboard</footer>
</body>
</html>
