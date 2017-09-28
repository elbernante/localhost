<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
<title>LocalHost</title>
</head>
<body>
     
	<h1>Send Request</h1>
		
  <form:form action="addrequest" modelAttribute="newRequest" method="post">
  <fieldset>
				<legend>Send Request</legend>
        
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="arrivalDate">Arrival Date </label>
					<div class="col-lg-10">
						<form:input id="arrivalDate" path="arrivalDate" type="text" class="form:input-large"/>
						<form:errors path="arrivalDate" cssClass="text-danger"/>
					</div>
				</div>
			<br></br>
				<div class="form-group">
					<label class="control-label col-lg-2" for="departureDate">Departure Date</label>
					<div class="col-lg-10">
						<form:input id="departureDate" path="departureDate" type="text" class="form:input-large"/>
						<form:errors path="departureDate" cssClass="text-danger"/>
					</div>
					<input type="hidden" name="id" value="${id}"/>
				</div>
			<br></br>
				<div class="form-group">
					<label class="control-label col-lg-2" for="numberOfTraveler">Number Of Traveler</label>
					<div class="col-lg-10">
						<form:input id="numberOfTraveler" path="numberOfTraveler" type="text" class="form:input-large"/>
						<form:errors path="numberOfTraveler" cssClass="text-danger"/>
					</div>
				</div>
				<br></br>
				<div class="form-group">
					<label class="control-label col-lg-2" for="sendMessage">Message :</label>
					<div class="col-lg-10">
						<form:textarea id="sendMessage" path="sendMessage" rows = "4"/>
					</div>
					
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnSend" class="btn btn-primary" value ="Send"/>
					</div>
				</div>
				<br></br>
			</fieldset>
 
  </form:form>

</body>
</html>