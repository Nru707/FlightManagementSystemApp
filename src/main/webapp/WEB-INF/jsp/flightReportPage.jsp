<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Base2.jsp"%>
	<br>
	<div class="text-center">
		<div class="routeshow-box">
			<h3 class="font-weight-bold text-dark">FLIGHT REPORTS</h3>
			<table class="table table-striped table-bordered ">
				<thead class="thead-dark">
					<tr>
						<th>Flight Number</th>
						<th>Airlines Name</th>
						<th>Route Id</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>SEATBOOKED</th>
						<th>Seat Available</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${flightList}" var="flight">
						<tr>
							<td><c:out value="${flight.flightNumber}" /></td>
							<td><c:out value="${flight.carrierName}" /></td>
							<td><c:out value="${flight.routeId}" /></td>
							<td><c:out value="${flight.departure}" /></td>
							<td><c:out value="${flight.arrival}" /></td>
							<td><c:out value="${flight.seatBooked}" /></td>
							<c:set var="seatAvailable" scope="session"
								value="${flight.seatCapacity-flight.seatBooked}" />
							<td><c:out value="${seatAvailable}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<footer> Flight Management System @2024 Infosys Springboard </footer>

</body>
</html>