<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="edu.mum.cs545.localhost.domain.ReferenceType" %>

<%-- <!DOCTYPE html>
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
		<input type="hidden" id="username" value="${userProfile.user.username}" />
		<h2>${userProfile.firstName} ${userProfile.lastName}'s <spring:message code="profile.view.title" /></h2>
		<h4>Photos, home, and more info here.</h4>
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
</html> --%>
<section id="profile-page">
	<div class="row">
		<sec:authentication property="principal" var="user"/>
		<input type="hidden" id="username" value="${userProfile.user.username}" />
		<h2>${userProfile.firstName} ${userProfile.lastName}'s <spring:message code="profile.view.title" /></h2>
	</div>
	<div class="row">
		<div class="col-30">
			<div>
				<img class="profile-image" alt="prrofile image" src="<spring:url value='/resources/images/user.png' />" />
			</div>
			<div>
				<a class="btn btn-menu" href="<spring:url value='/profile/${user.username}/aboutme'/>">About Me</a><br />
			</div>
		</div>
		<div class="col-70">
			<div class="tool-bar">
				<button class="btn btn-primary" type="button" id="postReference"><spring:message code="profile.view.referenceFormTitle" /></button>
				<a class="btn btn-primary" href="<spring:url value='/addrequest'/>"><spring:message code="profile.view.sendHostingRequest" /></a><br />
			</div>
			<div id="references" class="panel">
				<h4><spring:message code="profile.view.references" /></h4>
				<div id="referenceList"></div>
			</div>
		</div>
	</div>
</section>
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
	<button class="btn btn-primary" id="referenceFormConfirm"><spring:message code="profile.view.referenceFormConfirm" /></button>
	<button class="btn btn-primary" id="referenceFormCancel"><spring:message code="profile.view.referenceFormCancel" /></button>
	<p id="referenceFormError"></p>
</section>

