<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Booking</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .input-container {
            width: 100%;
            margin-bottom: 10px;
            position: relative;
        }
        .input-container input[type=text], 
        .input-container select {
            width: calc(100% - 40px); /* Adjust width minus icon width */
            padding: 10px;
            margin: 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            outline: none;
        }
        .input-container i {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            cursor: pointer;
        }
        .input-container .passenger-count {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .input-container .passenger-count select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            margin-left: 10px;
            outline: none;
        }
        .input-container .passenger-count .counter {
            display: flex;
            align-items: center;
        }
        .input-container .passenger-count .counter button {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            padding: 5px 10px;
            margin-left: 5px;
            outline: none;
        }
        .input-container .passenger-count .counter button:hover {
            background-color: #45a049;
        }
        .results {
            margin-top: 20px;
            text-align: center;
        }
        .results p {
            font-size: 18px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#travelDate").datepicker({
                dateFormat: 'yy-mm-dd'
            });

            $(".counter button").on("click", function() {
                var input = $(this).siblings("input");
                var currentValue = parseInt(input.val());
                if ($(this).hasClass("plus")) {
                    input.val(currentValue + 1);
                } else if ($(this).hasClass("minus") && currentValue > 0) {
                    input.val(currentValue - 1);
                }
                updateTotalPassengers();
            });

            function updateTotalPassengers() {
                var total = 0;
                $(".passenger-count select").each(function() {
                    total += parseInt($(this).siblings("input").val()) || 0;
                });
                $("#totalPassengers").text(total);
            }
        });
    </script>
</head>
<body>

<div class="container">
    <h1>Flight Booking</h1>
    <form action="flightBooking" method="get">
        <div class="input-container">
            <input id="from" type="text" name="from" placeholder="From (e.g., New York)" required>
        </div>
        <div class="input-container">
            <input id="to" type="text" name="to" placeholder="To (e.g., Los Angeles)" required>
        </div>
        <div class="input-container">
            <input type="text" id="travelDate" name="travelDate" placeholder="&#xf073; Travel Date" required>
            <!-- Placeholder icon for travel date (font-awesome) -->
            <i class="fa fa-calendar"></i>
        </div>
        <div class="input-container">
            <div class="passenger-count">
                <label for="passengerCount">No. of Passengers:</label>
                <div class="counter">
                    <button type="button" class="minus">-</button>
                    <input type="text" id="passengerCount" name="passengerCount" value="0">
                    <button type="button" class="plus">+</button>
                </div>
            </div>
        </div>

        <div class="input-container">
            <input type="submit" value="Search Flight">
        </div>

        <div class="input-container">
            <p>Total Passengers: <span id="totalPassengers">0</span></p>
        </div>
    </form>

    <c:if test="${not empty param.from}">
        <div class="results">
            <h2>Search Results</h2>
            <p>From: ${param.from}</p>
            <p>To: ${param.to}</p>
            <p>Travel Date: ${param.travelDate}</p>
            <p>No. of Passengers: ${param.passengerCount}</p>

            <!-- Placeholder for search results -->
            <p>No flights found. (This is a placeholder)</p>
        </div>
    </c:if>
</div>

</body>
</html>
