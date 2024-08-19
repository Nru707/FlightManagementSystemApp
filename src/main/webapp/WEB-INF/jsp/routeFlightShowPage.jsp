<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@include file="Base3.jsp" %>

	<div class=" text-center">
		<div class="report-box">
			<h3 class=" text-center font-weight-bold text-dark">FLIGHT DETAILS</h3>
			<table class="table table-striped table-bordered ">
				<thead class="thead-dark">
					<tr>
						<th>Flight Number</th>
						<th>Airlines Name</th>
						<th>Route Id</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>Seat Available</th>
						<th>Fare</th>
						<th>Booking</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="flight" items="${flightList}">
						<tr>
							<td>${flight.flightNumber}</td>
							<td>${flight.carrierName}</td>
							<td>${flight.routeId}</td>
							<td>${flight.departure}</td>
							<td>${flight.arrival}</td>
							<c:set var="seatAvailable" scope="session"
								value="${flight.seatCapacity-flight.seatBooked}" />
							<td>${seatAvailable}</td>
							<td>${fare}</td>
							<td><a
								href="${pageContext.request.contextPath}/customer/ticket/${flight.flightNumber}" class="home-link btn btn-primary">Book Ticket</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="${pageContext.request.contextPath}/customer/" class="home-link btn btn-primary">Back to Home</a>
		</div>
	</div>
	<footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>