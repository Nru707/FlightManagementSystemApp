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
	<div class=" text-center">
		<h3 class="font-weight-bold text-dark">AIRPORT DETAILS</h3>
		<table class="table table-striped table-bordered ">
			<thead class="thead-dark">
				<tr>
					<th>Ticket Number</th>
					<th>Passenger Name</th>
					<th>Passenger DOB</th>
					<th>Fare</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="passenger" items="${PassengerList}">
					<tr>
						<td>${passenger.embeddedId.ticketNumber}</td>
						<td>${passenger.passengerName}</td>
						<td>${passenger.passengerDOB}</td>
						<td>${passenger.fare}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/Admin/" class="btn btn-primary">Back Home</a>
		</div>

	</div>
</body>
</html>