<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Travel Plans</title>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/itinerary.css" />" />
</head>
<body>
	<sec:authentication property="principal" var="user"/>
	<div class="container content">
		<h2>${ user.username }'s Travel Plans</h2>
		<div class="toolbar">
			<button id="newDistination">Add a Destination</button>
		</div>
		<div class="itinerary-list">
			<div class="list-entry">
				<div class="label">Arrival Date:</div><div class="value">dd-MM-yyyy</div>
				<div class="label">Departure Date:</div><div class="value">dd-MM-yyyy</div>
				<div class="label">Destination:</div><div class="value">City, State, Country</div>
				<div class="message">Message goes here</div>
				<div class="buttons">
					<button>Edit</button><br />
					<button>Delete</button>
				</div>
			</div>
		</div>
	</div>

	<div class="popup-form">
		<form id="itinerary-form" action="<spring:url value='/itinerary/save' />" method="post">
			<h3>New Destination</h3>
			<fieldset>
				Arrival Date: <input type="text" name="arrivalDate" value="" /><br />
				Departure Date: <input type="text" name="departureDate" value="" /><br />
				City: <input type="text" name="city" value="" /><br />
				State: <input type="text" name="state" value="" /><br />
				Country: <input type="text" name="country" value="" /><br />
				Message: <textarea rows="3" cols="40" name="message"></textarea>
				<input type="hidden" name="id" value="" />
				<input type="hidden" name="user.id" value="11" />
			</fieldset>
			<input type="submit" value="Post Destination" />
		</form>
	</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="<spring:url value='/resources/lib/jquery/jquery-3.2.1.min.js' />"><\/script>');</script>
	<script src="<spring:url value='/resources/js/itinerary.js' />"></script>
</body>
</html>