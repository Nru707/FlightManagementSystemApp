<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@include file="Base3.jsp" %>
 <br>
                <div class="row justify-content-center">
                    <div class="col-md-8 details-container text-center">
                        <h1 class="details-title"><i>FLIGHT DETAILS</i></h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Flight Number</th>
                                    <th>Airlines Name</th>
                                    <th>Route Id</th>
                                    <th>Departure</th>
                                    <th>Arrival</th>
                                    <th>Seat Available</th>
                                    <th>Fare</th>
                                    <th>Booking</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="flight" items="${flightList}">
                                    <tr>
                                        <td>${flight.flightNumber}</td>
                                        <td>${flight.carrierName}</td>
                                        <td>${flight.routeId}</td>
                                        <td>${flight.departure}</td>
                                        <td>${flight.arrival}</td>
                                        <c:set var="seatAvailable" scope="session"
                                            value="${flight.seatCapacity-flight.seatBooked}" />
                                        <td>${seatAvailable}</td>
                                        <td>${fare}</td>
                                      <td><a href="/ticket/${flight.flightNumber}" >Book Ticket</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a href="/userindex" class="home-link btn btn-primary">Back to Home</a>
                    </div>
                </div>
</body>
</html>