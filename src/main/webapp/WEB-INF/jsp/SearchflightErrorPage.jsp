<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
<%@include file="Base2.jsp" %>
<br><br>

 <div class="container">
            <div class="login-box text-center">
	<h1 style="color:red"> ALERT!</h1>
	
<p>${errorMessage}</p>

 <a href="${pageContext.request.contextPath}/customer/flight-search" class="btn btn-primary">CLICK HERE TO RE-ENTER</a>
</div>
</div>
    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>

</body>
</html>