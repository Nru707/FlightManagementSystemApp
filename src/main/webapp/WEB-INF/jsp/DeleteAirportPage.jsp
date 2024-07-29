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
   <div style="text-align: center;">
   <br><br>
   <h3 >
   
   <form:form action="${pageContext.request.contextPath}/Admin/DeleteAirport" method="post" modelAttribute="airport">
    <input type="hidden" name="airportId" value="${airport.airportCode}" />
   ENTER AIRPORT CITY: <form:input  path="airportLocation" required="required"/>
   <br><br>
   ENTER AIRPORT CODE: <form:input  path="airportCode" required="required"/>
   <br><br>
    <button type="submit" class="btn btn-primary">DELETE AIRPORT</button>
  <a href="/admin/" type="submit" class="btn btn-primary">BACK HOME</a>

</form:form>
</h3>
</div>
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>


   </body>
</html>
