<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Route</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body>
	<%@include file="Base2.jsp"%>
	<div class="container">
		<div class="login-box">
			<h3 class="text-center">Update Route Form</h3>
			<br>
			<form:form
				action="${pageContext.request.contextPath}/Admin/updateroute" method="post" modelAttribute="routeRecord">
				<input type="hidden" name="routeId" value="${routeRecord.routeId}" />
				<div class="form-group">
					<label for="sourceAirportCode">Source Airport:</label><input
						type="text" class="form-control" id="sourceAirportCode" name="sourceAirportCode" value="${sourceAirport.airportLocation}" required>
				</div>
				<div class="form-group">
					<label for="destinationAirportCode">Destination Airport:</label> <input
						type="text" class="form-control" id="destinationAirportCode" name="destinationAirportCode" value="${destinationAirport.airportLocation}" required>
				</div>
				<div class="form-group">
					<label for="fare">Route Fare:</label><input type="text" class="form-control" id="fare" name="fare" value="${routeRecord.fare}" required>
				</div>
				<button type="submit" class="btn btn-primary">Update Route</button>
				<a href="${pageContext.request.contextPath}/Admin/" type="submit" class="btn btn-primary">BACK HOME</a>
			</form:form>

		</div>
	</div>
	<footer>
        Flight Management System @2024 Infosys Springboard
    </footer>

</body>
</html>