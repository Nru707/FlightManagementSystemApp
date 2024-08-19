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
           <h3 class="text-center">Airport Form</h3>
          <form:form action="${pageContext.request.contextPath}/Admin/airport" method="post" modelAttribute="airportRecord">
               <div class="form-group">
					<label for="airportLocation">ENTER AIRPORT CITY:</label> <input
						type="text" class="form-control" name="airportLocation" required>
				</div>
               <div class="form-group">
					<label for="airportCode"> ENTER AIRPORT CODE:</label> <input
						type="text" class="form-control" name="airportCode" required>
				</div>
                    <br><br>
                  <button type="submit" class="btn btn-primary">SUBMIT</button>
  <a href="${pageContext.request.contextPath}/Admin/" type="submit" class="btn btn-primary">BACK HOME</a>

            </form:form >
        </div>
    </div>
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>


   </body>
</html>
