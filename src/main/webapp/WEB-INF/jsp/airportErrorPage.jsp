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
<%@include file="Base2.jsp" %>
    <div class="container">
            <div class="login-box text-center">
                    <h1 style="color: red">Alert!</h1>
                    <p>${errorMessage}</p>
                    <a href="${pageContext.request.contextPath}/Admin/airport" class="btn btn-primary">Go Back</a>
                </div>
            </div>
             <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>

</body>
</html>