<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Route</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #4CAF50;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        h2 {
            text-align: center;
            color: #4CAF50;
            margin-bottom: 20px;
        }
        .form-group label {
            color: #333;
        }
        .form-control {
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn-primary {
            background-color: #4CAF50;
            border: none;
        }
        .alert {
            display: none;
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var successMessage = document.getElementById('successMessage');
            if (successMessage) {
                successMessage.style.display = 'block';
                setTimeout(function() {
                    successMessage.style.display = 'none';
                }, 3000); // Hide message after 3 seconds
            }

            var errorMessage = document.getElementById('errorMessage');
            if (errorMessage) {
                errorMessage.style.display = 'block';
                setTimeout(function() {
                    errorMessage.style.display = 'none';
                }, 3000); // Hide message after 3 seconds
            }
        });
    </script>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Add Route</h2>
        <form action="${pageContext.request.contextPath}/addRoute" method="post">
            <div class="form-group">
                <label for="sourceAirport">Source Airport</label>
                <input type="text" class="form-control" id="sourceAirport" name="sourceAirport" required>
            </div>
            <div class="form-group">
                <label for="destinationAirport">Destination Airport</label>
                <input type="text" class="form-control" id="destinationAirport" name="destinationAirport" required>
            </div>
            <div class="form-group">
                <label for="fare">Fare</label>
                <input type="number" step="0.01" class="form-control" id="fare" name="fare" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Add Route</button>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger mt-3" id="errorMessage">${errorMessage}</div>
            </c:if>
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success mt-3" id="successMessage">${successMessage}</div>
            </c:if>
        </form>
        <a href="${pageContext.request.contextPath}/index" class="btn btn-secondary btn-block mt-3">Return</a>
    </div>
</body>
</html>
