<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Home - Flight Management System</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>

</head>

<body>
 <%@include file="Base.jsp" %>
 <section class="banner d-flex justify-content-center align-items-center" >
 <div class="text-center">
 	<h1 class="font-weight-bold text-dark">FLIGHT MANAGEMENT SYSTEM</h1>
 	<p class="text-center text-dark">A flight management system (FMS) is a computerized system that automates various in-flight tasks,<br>
 							 making flying safer and more efficient. For passengers, an FMS ensures a smooth journey from check-in to departure.<br>
 						 The system connects the reservation system to the departure control system, verifying passenger information and issuing boarding documents.<br>
 						  During the flight, the FMS guides the aircraft along the flight plan, 
 						  providing real-time information to the pilots and ensuring a timely arrival at the destination.
 						  </p>
 						  
 	<a class="btn btn-primary" href="${pageContext.request.contextPath}/Login" role="button">START FROM HERE</a>
 	
 	</div>
 </section>
 
 <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
 
 
</body>
</html>