<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
			Retrieving itinerary...
		</div>
	</div>

	<div class="popup-form">
		<form id="itinerary-form" action="<spring:url value='/itinerary/save' />" method="post">
			<h3>Plan a Trip</h3>
			<div class="errors"></div>
			<fieldset>
				Arrival Date: <input type="text" name="arrivalDate" value="" placeholder="mm/dd/yyyy" /><br />
				Departure Date: <input type="text" name="departureDate" value="" placeholder="mm/dd/yyyy" /><br />
				City: <input type="text" name="city" value="" /><br />
				State: <input type="text" name="state" value="" /><br />
				Country: <input type="text" name="country" value="" /><br />
				Message: <textarea rows="3" cols="40" name="message"></textarea>
				<input type="hidden" name="id" value="" />
			</fieldset>
			<input type="submit" value="Post Destination" />
			<input type="button" class="cancel-btn" value="Cancel" />
		</form>
	</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="<spring:url value='/resources/lib/jquery/jquery-3.2.1.min.js' />"><\/script>');</script>
	<script src="<spring:url value='/resources/js/itinerary.js' />"></script>
</body>
</html> --%>

<sec:authentication property="principal" var="user"/>
<section id="travel-plan-page">
	<div>
		<h2>${ user.username }'s Travel Plans</h2>
		<div class="tool-bar">
			<button class="btn btn-primary" id="newDistination"><spring:message code="itinerary.view.addDestination" /></button>
		</div>
		<div class="itinerary-list">
			<spring:message code="itinerary.view.retrievingItinerary" />
		</div>
	</div>
</section>
<section>
	<div class="popup-form panel">
		<form id="itinerary-form" action="<spring:url value='/itinerary/save' />" method="post">
			<h3>Plan a Trip</h3>
			<div class="error-message"></div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.arrivalDate" /></label>
				<input type="text" name="arrivalDate" value="" placeholder="mm/dd/yyyy" />
			</div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.departureDate" /></label>
				<input type="text" name="departureDate" value="" placeholder="mm/dd/yyyy" />
			</div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.city" /></label>
				<input type="text" name="city" value="" />
			</div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.state" /></label>
				<input type="text" name="state" value="" />
			</div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.country" /></label>
				<input type="text" name="country" value="" />
			</div>
			<div class="labeled-field">
				<label><spring:message code="itinerary.view.message" /></label>
				<textarea rows="3" cols="40" name="message"></textarea>
			</div>
			<input type="hidden" name="id" value="" />
			<div class="tool-bar">
				<input class="btn btn-secondary" type="submit" value="<spring:message code="itinerary.view.postDestination" />" />
				<input class="btn btn-secondary cancel-btn" type="button" value="<spring:message code="itinerary.view.cancel" />" />
			</div>
		</form>
	</div>
</section>