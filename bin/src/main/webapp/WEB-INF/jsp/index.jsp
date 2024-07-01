<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Management System - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            padding: 10px 0;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
            position: relative;
        }
        nav ul li {
            display: inline-block;
            margin: 0 10px;
            position: relative;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            padding: 10px;
            display: block;
        }
        nav ul li a:hover {
            background-color: #575757;
        }
        .dropdown {
            display: none;
            position: absolute;
            background-color: #4CAF50;
            min-width: 160px;
            z-index: 1;
            left: 0;  /* Aligns the dropdown to the left of the parent */
            top: 40px;  /* Positions dropdown directly below the parent */
            border-radius: 5px;
        }
        .dropdown a {
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
            background-color: #4CAF50;
            border-bottom: 1px solid #ddd;
        }
        .dropdown a:hover {
            background-color: #45a049;
        }
        .dropdown a:last-child {
            border-bottom: none;
        }
        .toggle-sign {
            cursor: pointer;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .search-section {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .search-section h2 {
            color: #333;
            margin-bottom: 10px;
        }
        .search-section label {
            display: block;
            margin-bottom: 5px;
        }
        .search-section input[type="text"],
        .search-section input[type="date"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .search-section input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .flight-listings {
            margin-top: 20px;
        }
        .flight {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .flight h3 {
            color: #333;
        }
        .flight p {
            margin: 5px 0;
        }
        .flight button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        footer {
            text-align: center;
            padding: 10px;
            background-color: #f1f1f1;
        }
    </style>
    <script>
        function toggleDropdown(id, signId) {
            var dropdown = document.getElementById(id);
            var toggleSign = document.getElementById(signId);
            if (dropdown.style.display === "block") {
                dropdown.style.display = "none";
                toggleSign.innerHTML = "&#x25BC;"; // Down arrow
            } else {
                dropdown.style.display = "block";
                toggleSign.innerHTML = "&#x25B2;"; // Up arrow
            }
        }
    </script>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li>
                    <a href="javascript:void(0);" class="toggle-sign" onclick="toggleDropdown('airportDropdown', 'airportToggleSign')">Airport <span id="airportToggleSign">&#x25BC;</span></a>
                    <div class="dropdown" id="airportDropdown">
                        <a href="addAirport">Add Airport</a>
                        <a href="airportlist">View All Airports</a>
                        <a href="airportview">Find Airport</a>
                    </div>
                </li>
                <li>
                    <a href="javascript:void(0);" class="toggle-sign" onclick="toggleDropdown('flightDropdown', 'flightToggleSign')">Route <span id="flightToggleSign">&#x25BC;</span></a>
                    <div class="dropdown" id="flightDropdown">
                        <a href="${pageContext.request.contextPath}/addRoute">Add Route</a>
                        <a href="${pageContext.request.contextPath}/viewRoute">View All Routes</a>
                    </div>
                </li>
                <li>
                    <a href="javascript:void(0);" class="toggle-sign" onclick="toggleDropdown('flightsDropdown', 'flightsToggleSign')">Flights <span id="flightsToggleSign">&#x25BC;</span></a>
                    <div class="dropdown" id="flightsDropdown">
                        <a href="${pageContext.request.contextPath}/addFlight">Add Flight</a>
                        <a href="${pageContext.request.contextPath}/viewFlight">View Flights</a>
                        <a href="${pageContext.request.contextPath}/searchFlight">Search Flights</a>
                    </div>
                </li>
                <li><a href="login">LogOut</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1>Welcome to Flight Management System</h1>
        <section class="search-section">
            <h2>Search Flights</h2>
            <form action="searchFlights" method="get">
                <label for="origin">Origin:</label>
                <input type="text" id="origin" name="origin" required>
                <label for="destination">Destination:</label>
                <input type="text" id="destination" name="destination" required>
                <label for="departure-date">Departure Date:</label>
                <input type="date" id="departure-date" name="departure-date" required>
                <label for="return-date">Return Date:</label>
                <input type="date" id="return-date" name="return-date">
                <input type="submit" value="Search">
            </form>
        </section>

        <section class="flight-listings">
            <h2>Available Flights</h2>
            <!-- Flight listings will be dynamically populated here -->
            <div class="flight">
                <h3>Flight 1</h3>
                <p>Airline: XYZ Airlines</p>
                <p>Departure: City A</p>
                <p>Arrival: City B</p>
                <p>Departure Time: 12:00 PM</p>
                <p>Arrival Time: 2:00 PM</p>
                <p>Price: $200</p>
                <button>Book Now</button>
            </div>
            <div class="flight">
                <!-- Flight 2 details -->
            </div>
            <!-- More flight listings -->
        </section>
    </div>

    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>
