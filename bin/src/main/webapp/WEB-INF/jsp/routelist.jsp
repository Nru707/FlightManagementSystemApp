<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Route List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 50px;
        }
        h2 {
            color: #4CAF50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Route List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Route ID</th>
                    <th>Source Airport Code</th>
                    <th>Destination Airport Code</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="route" items="${routes}">
                    <tr>
                        <td>${route.routeId}</td>
                        <td>${route.sourceAirportCode}</td>
                        <td>${route.destinationAirportCode}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/index" class="btn btn-secondary btn-block mt-3">Return to Home</a>
    </div>
</body>
</html>
