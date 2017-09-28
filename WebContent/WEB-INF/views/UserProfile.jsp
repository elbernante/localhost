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

	<h1>Hi! This is Your Registration Page</h1>
		
	<button type="submit" id="btnSend" class="btn btn-primary" class="btn btn-default btn-lg" onclick="make_visible('addressForm')">Add Address</button>
				
  <form:form action="addProfile" modelAttribute="newUserProfile" method="post">
  <fieldset>
				<legend>Registration</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName">First Name: </label>
					<div class="col-lg-10">
					<form:input id="fname" path="firstName" type="text" class="form:input-large"/>
						<form:errors path="firstName" cssClass="text-danger"/>
						
					</div>
				</div>
				<br></br>
				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last Name :</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
						<form:errors path="lastName" cssClass="text-danger"/>
					</div>
					
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="occupation">Occupation :</label>
					<div class="col-lg-10">
						<form:input id="occupation" path="occupation" type="text" class="form-control input-lg"/>
						<form:errors path="occupation" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="countriesVisited">Countries I've Visited :</label>
					<div class="col-lg-10">
					<form:input id="countriesVisited" path="countriesVisited" type="text" class="form-control input-lg"/>
	
						<form:errors path="countriesVisited" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="countriesLived">Countries I've Lived In :</label>
					<div class="col-lg-10">
						<form:input id="countriesLived" path="countriesLived" type="text" class="form-control input-lg"/>
						<form:errors path="countriesLived" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="education">Education :</label>
					<div class="col-lg-10">
						<form:input id="education" path="education" type="text" class="form-control input-lg"/>
						<form:errors path="education" cssClass="text-danger"/>
					</div>
				</div>
				

				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="user">User Name :</label>
					<div class="col-lg-10">
						<form:input id="user" path="user.username" type="text" class="form-control input-lg"/>
						<form:errors path="user.username" cssClass="text-danger"/>
					</div>
			
					</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="user">password :</label>
					<div class="col-lg-10">
						<form:input id="user" path="user.password" type="text" class="form-control input-lg"/>
						<form:errors path="user.password" cssClass="text-danger"/>
					</div>
					</div>
					
					<div class="form-group">
					<label class="control-label col-lg-2" for="user">Verify Password :</label>
					<div class="col-lg-10">
						<form:input id="user" path="user.verifyPassword" type="text" class="form-control input-lg"/>
						<form:errors path="user.verifyPassword" cssClass="text-danger"/>
					</div>
					</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnSend" class="btn btn-primary" value ="Save"/>
					</div>
				</div>
				
			</fieldset>
 
  </form:form>
  
  
 <div id="addressForm" style="display:none" >

 <%-- <form:form action="addAddress">
  <p><form:input path="street"/></p>
  <p><form:input path="city"/></p>
  <p><form:input path="ZipCode"/></p>
  <p><form:input path="country"/></p>
 <form:button type="submit" value ="Add Address" onClick="addAddress(addressForm)"/> 

</form:form> --%>

</div>

</body>
</html>