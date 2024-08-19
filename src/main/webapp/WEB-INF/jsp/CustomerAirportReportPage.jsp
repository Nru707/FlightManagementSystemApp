<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head >
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body >
 <%@include file="Base3.jsp" %>
 <div class=" text-center">
		<div class="report-box">
			<h3 class=" text-center font-weight-bold text-dark">AIRPORT REPORT</h3>
			<table class="table table-striped table-bordered ">
				<thead class="thead-dark">
					<tr>
						<th>AIRPORT CODE</th>
						<th>AIRPORT LOCATION</th>
						<th>ENQUIRE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${airportList }" var="airport">
						<tr>
							<td><c:out value="${airport.airportCode}" /></td>
							<td><c:out value="${airport.airportLocation}" /></td>
							<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/airport/${airport.airportCode}" role="button">ENQUIRE</a></td>
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