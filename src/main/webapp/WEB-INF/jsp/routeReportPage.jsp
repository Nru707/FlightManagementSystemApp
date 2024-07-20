<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body>
<header>
 <%@include file="Base2.jsp" %>
 </header>
<div class=" text-center">
	<h3 class="font-weight-bold text-dark">ROUTE LIST</h3>
	<table class="table table-striped table-bordered ">
  <thead class="thead-dark">
    <tr>
    <th>ROUTE ID</th>
    <th>SOURCE CODE</th>
	<th>DESTINATION CODE</th>
	<th>ROUTE FARE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${routeList }" var="route">
    <tr>
    <td><c:out value="${route.routeId}" /></td>
    <td><c:out value="${route.sourceAirportCode}" /></td>
	<td><c:out value="${route.destinationAirportCode}" /></td>
	<td><c:out value="${route.fare}" /></td>
    </tr>
    </c:forEach>
  
  </tbody>
  
</table>
	<br>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/index" role="button">RETURN TO HOME</a>
</div>

 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>

</body>
</html>