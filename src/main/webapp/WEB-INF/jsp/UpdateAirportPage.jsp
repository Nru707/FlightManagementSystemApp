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
           <h3 class="text-center">Update Airport Form</h3>
           <br>
           <form:form action="${pageContext.request.contextPath}/Admin/UpdateAirport" method="post" modelAttribute="airport">
            <div class="form-group">
           <label>ENTER AIRPORT CITY: </label><form:input  path="sourceAirportCode" class="form-control"  value="${destinationAirport.airportLocation}" required="required"/>
   			</div>
   		   <div class="form-group">
  		 	<label>ENTER AIRPORT CODE:</label> <form:input  path="destinationAirportCode"  class="form-control" required="required"/>
  			 </div>
    <button type="submit" class="btn btn-primary">SAVE CHANGES</button>
  <a href="${pageContext.request.contextPath}/Admin/" type="submit" class="btn btn-primary">BACK HOME</a>

</form:form>
</div>
</div>
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>


   </body>
</html>
