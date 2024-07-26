<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%@include file="Base3.jsp" %>
<br>
 <div class="details-container" align="center">
                <form:form action="${pageContext.request.contextPath}/Customer/ticket" method="post" modelAttribute="ticketRecord">
                    <form:hidden path="ticketNumber" />
                    <form:hidden path="flightNumber" />
                    <form:hidden path="carrierName" />
                    <input type="hidden" name="fromLocation" value="${route.sourceAirportCode}" />
                    <input type="hidden" name="toLocation" value="${route.destinationAirportCode}" />
                    <input type="hidden" name="fare" value="${route.fare}" />
                    <h3>Flight Booking Details</h3>
                    <table>
                        <tr>
                            <td><label class="required">Ticket Number : </label><form:input path="ticketNumber" disabled="true" /></td>
                            <td><label class="required">Flight Number : </label><form:input path="flightNumber" disabled="true" /></td>
                            <td><label class="required">Airlines Name : </label><form:input path="carrierName" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td><label class="required">From : </label><input type="text"  value="${route.sourceAirportCode}" disabled="true" /></td>
                            <td><label class="required" >To : </label><input type="text"  value="${route.destinationAirportCode}" disabled="true"  /></td>
                            <td><label class="required" >Fare : </label><input type="text"  value="${route.fare}"  disabled="true"/></td>
                        </tr>
                    </table>

                    <h3>Enter Passenger Details :</h3>
                    <table>
                        <tr>
                            <td>Name : <input type="text" name="name1" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob1" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder="25-10-2024" required></td>
                        </tr>
                        <tr>
                            <td>Name : <input type="text" name="name2" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob2" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder=25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td>Name : <input type="text" name="name3" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob3" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder=25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td>Name : <input type="text" name="name4" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob4" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder=25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td>Name : <input type="text" name="name5" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob5" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder=25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td>Name : <input type="text" name="name6" value="--" placeholder="John Doe"></td>
                            <td>Date Of Birth : <input type="date" name="dob6" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder=25-10-2024" ></td>
                        </tr>
                    </table>

                    <button type="submit">Submit</button>

                </form:form>
            </div>
      <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
     

</body>
</html>