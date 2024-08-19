<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
.input-group-text {
   width: 30%;
} 
</style>
</head>
<body>
<%@include file="Base3.jsp" %>
        <div class="flightbook-box">
            <div class="card-header text-center">
            <form:form action="${pageContext.request.contextPath}/customer/ticket" method="post" modelAttribute="ticketRecord">
                    <form:hidden path="ticketNumber" />
                    <form:hidden path="flightNumber" />
                    <form:hidden path="carrierName" />
                    <input type="hidden" name="fromLocation" value="${route.sourceAirportCode}" />
                    <input type="hidden" name="toLocation" value="${route.destinationAirportCode}" />
                    <input type="hidden" name="fare" value="${route.fare}" />
                    <h3>Flight Booking Details</h3>
            <div class="card-body">

                <div class="row">
                    <div class="col-6">
                        <div class="input-group mb-3">
                            <span class="input-group-text" >Ticket No.</span>
                            <form:input path="ticketNumber" class="form-control" disabled="true" />
                        </div>
            
                        <div class="input-group mb-3">
                            <span class="input-group-text" >Flight No.</span>
                            <form:input path="flightNumber" class="form-control" disabled="true" />
                        </div>
            
                        <div class="input-group mb-3">
                            <span class="input-group-text" >Airline Name</span>
                            <form:input path="carrierName" class="form-control" disabled="true" />
                        </div>
                    </div>
                    <div class="col-6">
                      
                        <div class="input-group mb-3">
                            <span class="input-group-text" >From </span>
                            <input type="text"  value="${route.sourceAirportCode}" class="form-control" disabled="true" />
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" >To</span>
                            <input type="text"  value="${route.destinationAirportCode}"  class="form-control" disabled="true"  />
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" >Fare</span>
                            <input type="text"  value="${route.fare}"  class="form-control" disabled="true"/>
                        </div>
                    </div>
                </div>
               </div>

                    <h3>Enter Passenger Details :</h3>
                    
                    <table class="table table-striped table-bordered ">
                    <thead class="thead-dark">
					<tr>
						<th>PASSENGER NAME</th>
						<th>PASSENGER AGE</th>
					</tr>
				</thead>
						 <tr>
                            <td><input type="text"  name="name1" placeholder="Enter Passenger Name" required></td>
                            <td><input type="date" name="dob1" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder="25-10-2024" required></td>
                        </tr>
                         <tr>
                            <td><input type="text" name="name2"  value="--" placeholder="Enter Passenger Name"></td>
                            <td><input type="date" name="dob2" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="25-10-2024" ></td>
                        </tr>
                         <tr>
                            <td><input type="text" name="name3" value="--" placeholder="Enter Passenger Name"></td>
                            <td><input type="date" name="dob3" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder="25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="name4" value="--" placeholder="Enter Passenger Name""></td>
                            <td><input type="date" name="dob4" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="name5" value="--" placeholder="Enter Passenger Name"></td>
                            <td><input type="date" name="dob5" pattern="\d{1,2}-\d{1,2}-\d{4}" placeholder="25-10-2024" ></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="name6" value="--" placeholder="Enter Passenger Name"></td>
                            <td><input type="date" name="dob6" pattern="\d{1,2}-\d{1,2}-\d{4}"  placeholder="25-10-2024" ></td>
                        </tr>
                    </table>
                    <button type="submit" class="home-link btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-secondary btn-custom">Reset</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/" role="button">RETURN </a>
                    </form:form>
				</div>
          </div>
            <br>
            <br>
            <br>
            <br>
  
      <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
    
     

</body>
</html>