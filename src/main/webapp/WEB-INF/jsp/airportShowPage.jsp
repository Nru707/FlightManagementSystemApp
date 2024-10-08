<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airport Details</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body>
	<%@include file="Base2.jsp"%>
	<div class="container text-center">
		<div class="reportshow-box">
			<h3 class=" text-center font-weight-bold text-dark">AIRPORT
				DETAILS</h3>
			<table class="table table-striped table-bordered ">
				<thead class="thead-dark">
					<tr>
						<th>AIRPORT CODE</th>
						<th>AIRPORT LOCATION</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${airport.airportCode}" /></td>
						<td><c:out value="${airport.airportLocation}" /></td>
					</tr>
				</tbody>
			</table>
			<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/Admin/" role="button">RETURN
			TO HOME</a>
		</div>
	</div>
	<!--  <br>
	<div class=" text-center">
		<h3 class="font-weight-bold text-dark">AIRPORT DETAILS</h3>
		<table class="table table-striped table-bordered ">
			<thead class="thead-dark">
				<tr>
					<th>AIRPORT CODE</th>
					<th>AIRPORT LOCATION</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${airport.airportCode}" /></td>
					<td><c:out value="${airport.airportLocation}" /></td>
				</tr>
			</tbody>
		</table>
		<br> <a class="btn btn-primary"
			href="${pageContext.request.contextPath}/Admin/" role="button">RETURN
			TO HOME</a>
	</div>
	-->

	<footer> Flight Management System @2024 Infosys Springboard </footer>
</body>
</html>