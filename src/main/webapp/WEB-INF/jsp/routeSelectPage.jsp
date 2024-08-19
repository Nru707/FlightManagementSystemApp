<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<%@include file="Base3.jsp"%>
	 <div class="container">
        <div class="login-box">
           <h3 class="text-center">Route Search Form</h3>
           <form:form id="flightForm" action="${pageContext.request.contextPath}/customer/flight-search" method="post">
               <div class="form-group">
					<label for="fromCity">Enter Source Airport:</label> <input
						type="text" class="form-control" name="fromCity" required>
				</div>
               <div class="form-group">
					<label for="toCity">Enter Destination Airport:</label> <input
						type="text" class="form-control" name="toCity" required>
				</div>
                    <br><br>
                 <input class="bg-primary" type="submit" herf="/user/userindex"value="Submit">
            </form:form >
        </div>
    </div>
    
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>