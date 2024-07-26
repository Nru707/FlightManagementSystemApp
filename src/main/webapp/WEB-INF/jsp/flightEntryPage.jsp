<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Base2.jsp" %>
                    <div class="row justify-content-center">
                        <div class="col-md-8 form-container">
                            <h3 class="text-center form-title">Flight Form</h3>
                            <form:form action="${pageContext.request.contextPath}/Admin/flight" method="post" modelAttribute="flightRecord">
                                <div class="form-group">
                                    <label for="flightNumber">Enter Flight ID:</label>
                                    <form:input path="flightNumber" class="form-control" id="flightNumber" />
                                </div>
                                <div class="form-group">
                                    <label for="carrierName">Enter Airlines Name:</label>
                                    <form:input path="carrierName" class="form-control" id="carrierName" />
                                </div>
                                <div class="form-group">
                                    <label for="routeId">Select Route ID:</label>
                                    <form:input list="routes" path="routeId" class="form-control" id="routeId" />
                                    <datalist id="routes">
                                        <c:forEach items="${routeList}" var="route">
                                            <option value="${route}"></option>
                                        </c:forEach>
                                    </datalist>
                                </div>
                                <div class="form-group">
                                    <label for="seatCapacity">Enter Seat Capacity:</label>
                                    <form:input path="seatCapacity" class="form-control" id="seatCapacity" />
                                </div>
                                <!-- The departure and arrival fields map to the Flight object and are handled by @ModelAttribute -->
                                <div class="form-group">
                                    <label for="departure">Enter Departure Time:</label>
                                    <form:input path="departure" class="form-control" id="departure" />
                                </div>
                                <div class="form-group">
                                    <label for="arrival">Enter Arrival Time:</label>
                                    <form:input path="arrival" class="form-control" id="arrival" />
                                 </div>
                                <form:hidden path="seatBooked" value="0" />
                                <!-- dtime and atime are not part of the Flight object and are handled separately by @RequestParam -->
                                <div class="form-group">
                                    <label for="dtime">Enter Return Flight Departure Time:</label>
                                    <input type="text" name="dtime" class="form-control" id="dtime" />
                                </div>
                                <div class="form-group">
                                    <label for="atime">Enter Return Flight Arrival Time:</label>
                                    <input type="text" name="atime" class="form-control" id="atime" />
                                </div>
                                <div class="text-center">
                                    <button type="submit"  class="btn btn-primary btn-custom">Submit</button>
                                    <button type="reset" class="btn btn-secondary btn-custom">Reset</button>
                                    <a href="${pageContext.request.contextPath}/Admin/" class="btn btn-secondary btn-custom">Back</a>
                                </div>
                            </form:form>
                        
                        </div>
                    </div>
                    

</body>
</html>