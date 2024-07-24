<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="Base3.jsp" %>

 <div class="row justify-content-center">
                        <div class="col-md-6 form-container">
                            <h3 class="text-center form-title">Route Form</h3>
                            <form id="flightForm" action="/flight-search" method="post">
                                <div class="form-group">
                                    <label for="fromCity">Enter Source Airport:</label>
                                    <input type="text" class="form-control"  name="fromCity" required>
                                </div>
                                <div class="form-group">
                                    <label for="toCity">Enter Destination Airport:</label>
                                    <input type="text" class="form-control"  name="toCity" required>
                                </div>

                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary btn-custom">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>

</body>
</html>