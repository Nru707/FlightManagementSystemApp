<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body>
 <%@include file="Base2.jsp" %>
  <div class="container">
        <div class="login-box">
           <h3 class="text-center">Route Entry Form</h3>
           <form:form action="${pageContext.request.contextPath}/Admin/route" method="post" modelAttribute="routeRecord">
               <div class="form-group">
               <form:hidden path="routeId"/>
					<label for="sourceAirportCode">ENTER SOURCE CITY:</label> <input
						type="text" class="form-control" name="sourceAirportCode" required>
				</div>
               <div class="form-group">
					<label for="airportCode"> ENTER DESTINATION CITY:</label> <input
						type="text" class="form-control" name="destinationAirportCode" required>
				</div>
				<div class="form-group">
					<label> ENTER ROUTE FARE:</label> <input
						type="text" class="form-control" name="fare" required>
				</div>
                  <button type="submit" class="btn btn-primary">SUBMIT</button>
  <a href="${pageContext.request.contextPath}/Admin/" type="submit" class="btn btn-primary">BACK HOME</a>

            </form:form >
        </div>
    </div>
  <!--   <div style="text-align: center;">
   <br><br>
   <h3 >
   <form:form action="${pageContext.request.contextPath}/Admin/route" method="post" modelAttribute="routeRecord">
   <form:hidden path="routeId"/>
   ENTER SOURCE CITY: <form:input  path="sourceAirportCode" required="required"/>
   <br><br>
   ENTER DESTINATION CITY: <form:input  path="destinationAirportCode" required="required"/>
   <br><br>
   ENTER ROUTE FAIR: <form:input  path="fare" required="required"/>
   <br><br>
  <button type="submit" class="btn btn-primary">SUBMIT</button>
  <a href="${pageContext.request.contextPath}/Admin/" type="submit" class="btn btn-primary">BACK HOME</a>

</form:form>
</h3>
</div>-->
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>


</body>
</html>