<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Base3.jsp"%>
<div class="container tickets-table">
	<h2>My Tickets</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Ticket Number</th>
				<th>Flight Number</th>
				<th>Carrier Name</th>
				<th>From</th>
				<th>To</th>
				<th>Arrival</th>
				<th>Departure</th>
				<th>Passenger Name</th>
				<th>Age</th>
				<th>Fare</th>
				<th>Update Details</th>
				<th>Cancel Ticket</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${ticketPassengerMap}">
				<c:forEach var="passenger" items="${entry.value}">
					<tr>
						<td>${entry.key.ticketNumber}</td>
						<td>${entry.key.flightNumber}</td>
						<td>${entry.key.carrierName}</td>
						<td>${entry.key.sourceAirport}</td>
						<td>${entry.key.destinationAirport}</td>
						<td>${entry.key.arrivalTime}</td>
						<td>${entry.key.departureTime}</td>
						<td>${passenger.passengerName}</td>
						<td>${passenger.passengerAge}</td>
						<td>${passenger.fare}</td>
						<td><a href="/updateticket/${entry.key.ticketNumber}"
							class="btn btn-secondary">Update</a></td>
						<td><a href="/deleteticket/${entry.key.ticketNumber}"
							class="btn btn-danger">Remove</a></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
	<a href="/index" class="btn btn-primary">Back to Home</a>
</div>


</body>
</html>