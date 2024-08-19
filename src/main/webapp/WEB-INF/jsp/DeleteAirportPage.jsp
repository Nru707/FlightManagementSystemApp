<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   
   <%@include file="Base2.jsp" %>
    <div class="container">
        <div class="login-box">
           <h3 class="text-center">Delete Airport Form</h3>
           <br>
   <form:form action="${pageContext.request.contextPath}/Admin/DeleteAirport" method="post" modelAttribute="airport">
    <input type="hidden" name="airportId" value="${airport.airportCode}" />
   <div class="form-group">
           <label>ENTER AIRPORT CITY: </label><form:input  path="airportLocation" class="form-control" required="required"/>
   			</div>
   		   <div class="form-group">
  		 	<label>ENTER AIRPORT CODE:</label> <form:input  path="airportCode"  class="form-control" required="required"/>
  			 </div>
    <button type="submit" class="btn btn-primary">DELETE AIRPORT</button>
  <a href="/admin/" type="submit" class="btn btn-primary">BACK HOME</a>

</form:form>
</div>
</div>
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>


   </body>
</html>
