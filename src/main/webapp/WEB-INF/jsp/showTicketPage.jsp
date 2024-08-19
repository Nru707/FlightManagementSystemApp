<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking Confirmation</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
.input-group-text {
   width: 30%;
} 
</style>
</head>
  <body>
  <%@include file="Base3.jsp" %>
	<div class="flightbook-box">
		<div class="card-header text-center">
			<h2 class="mb-4 text-center">Ticket Confirmation</h2>
			<div class="row">
				<div class="col-6">
					<div class="input-group mb-3">
						<span class="input-group-text">Ticket No.</span> <input
							type="text" value="${ticketRecord.ticketNumber}"
							class="form-control" disabled="true" />
					</div>

					<div class="input-group mb-3">
						<span class="input-group-text">Flight No.</span> <input
							type="text" value="${ticketRecord.flightNumber}"
							class="form-control" disabled="true" />
					</div>

					<div class="input-group mb-3">
						<span class="input-group-text">Carrier Name:</span> <input
							type="text" value="${ticketRecord.carrierName}"
							class="form-control" disabled="true" />
					</div>
				</div>
				<div class="col-6">

					<div class="input-group mb-3">
						<span class="input-group-text">From </span> <input type="text"
							value="${fromCity}" class="form-control" disabled="true" />
					</div>

					<div class="input-group mb-3">
						<span class="input-group-text">To</span> <input type="text"
							value="${toCity}" class="form-control" disabled="true" />
					</div>
				</div>
			</div>

			<h3>Passenger Details: </h3>
			<div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
						<tr>
							<th>Passenger Name</th>
							<th>Date Of Birth</th>
							<th>fare</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="passenger" items="${passengerList}">
							<tr>
								<td>${passenger.passengerName}</td>
								<td>${passenger.passengerDOB}</td>
								<td>${passenger.fare}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="right"><strong>Total Amount:</strong></td>
							<td><strong> ${ticket.totalAmount}</strong></td>
						</tr>
					</tbody>
				</table>
				<button onclick="window.print()" class="home-link btn btn-primary">Print</button>
			</div>
			<!--  <form:form action=" " method="post" modelAttribute="ticketRecord">
                                <input type="hidden" name="ticketNumber" value="${ticketRecord.ticketNumber}" />
                                <button type="submit" class="btn btn-danger">Cancel Ticket</button>
                            </form:form>  -->
                </div>

	</div>
	<br>
	<br>
	<br>
	<br>

	<footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
 
                        
</body>
</html>