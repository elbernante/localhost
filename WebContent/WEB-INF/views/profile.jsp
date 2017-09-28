<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="edu.mum.cs545.localhost.domain.ReferenceType" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="profile.view.title" /></title>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<spring:url value="/resources/js/profile.js" />"></script>
</head>
<body>
	<header>
		<sec:authentication property="principal" var="user"/>
		<input type="hidden" id="username" value="${user.username}" />
		<h2>${ user.username }'s <spring:message code="profile.view.title" /></h2>
		<h4>Photos, home, and more info about ${ user.username } here.</h4>
	</header>
	<nav>
		<button type="button" id="postReference"><spring:message code="profile.view.referenceFormTitle" /></button><br />
		<a href="<spring:url value='/addrequest'/>">Send Request</a><br />
		<a href="<spring:url value='/viewRequest'/>">show Request</a><br />
		<a href="<spring:url value='/listhost'></spring:url>">List Host</a><br />
		<a href="<spring:url value='/profile/${user.username}/aboutme'/>">About Me</a><br />
		<a href="<spring:url value='/logout' />">Log out</a>
	</nav>
	<section id="postReferenceForm">
		<h4><spring:message code="profile.view.referenceFormTitle" /></h4>
		<label for="referenceFormType"><spring:message code="profile.view.referenceFormType" /></label>
		<select id="referenceFormType">
			<option value="${ReferenceType.POSITIVE}"><spring:message code="profile.view.typePositive" /></option>
			<option value="${ReferenceType.NEUTRAL}"><spring:message code="profile.view.typeNeutral" /></option>
			<option value="${ReferenceType.NEGATIVE}"><spring:message code="profile.view.typeNegative" /></option>
		</select>
		<label for="referenceFormDescription"><spring:message code="profile.view.referenceFormDescription" /></label>
		<input id="referenceFormDescription" />
		<button id="referenceFormConfirm"><spring:message code="profile.view.referenceFormConfirm" /></button>
		<button id="referenceFormCancel"><spring:message code="profile.view.referenceFormCancel" /></button>
		<p id="referenceFormError"></p>
	</section>
	<section id="references">
		<h4><spring:message code="profile.view.references" /></h4>
		<div id="referenceList"></div>
	</section>
</body>
</html>