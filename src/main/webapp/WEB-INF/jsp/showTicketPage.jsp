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
  <body>
  <%@include file="Base2.jsp" %>
                    <h2 class="mb-4 text-center">Ticket Confirmation</h2>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Booking Details</h5>
                            <p class="card-text"><strong>Ticket Number:</strong> ${ticketRecord.ticketNumber}</p>
                            <p class="card-text"><strong>Carrier Name:</strong> ${ticketRecord.carrierName}</p>
                            <p class="card-text"><strong>Flight Number:</strong> ${ticketRecord.flightNumber}</p>
                            <p class="card-text"><strong>Route ID:</strong> ${ticketRecord.routeId}</p>
                            <p class="card-text"><strong>Total Amount:</strong> ${ticketRecord.totalAmount}</p>

                            <h5 class="card-title">Passenger Details</h5>
                            <div class="table-responsive">
                                <table class="table table-striped table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Passenger Name</th>
                                            <th>Age</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="passenger" items="${passengerList}">
                                            <tr>
                                                <td>${passenger.passengerName}</td>
                                                <td>${passenger.passengerAge}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <!-- Cancel Ticket Form 
                            <form:form action="/cancelTicket/${ticketRecord.ticketNumber}" method="post"
                                modelAttribute="ticketRecord">
                                <input type="hidden" name="ticketNumber" value="${ticketRecord.ticketNumber}" />
                                <button type="submit" class="btn btn-danger">Cancel Ticket</button>
                            </form:form>-->
                        </div>
                    </div>
                    <a href="/index" class="btn btn-primary mt-4">Back to Home</a>
</body>
</html>