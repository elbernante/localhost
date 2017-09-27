<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="edu.mum.cs545.localhost.domain.ReferenceType" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Profile</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<spring:url value="/resources/js/profile.js" />"></script>
</head>
<body>
	<header>
		<sec:authentication property="principal" var="user"/>
		<input type="hidden" id="username" value="${user.username}" />
		<h2>${ user.username }'s Profile</h2>
		<h4>Photos, home, and more info about ${ user.username } here.</h4>
	</header>
	<nav>
		<button type="button">Send Request</button>
		<a href="<spring:url value='/addrequest'/>">Send Request</a>
		<button type="button" id="postReference"><spring:message code="view.profile.referenceFormTitle" /></button>
		<a href="<spring:url value='/logout' />">Log out</a>
	</nav>
	<section id="postReferenceForm">
		<h4><label for="referenceFormTitle"><spring:message code="view.profile.referenceFormTitle" /></label></h4>
		<label for="referenceFormType"><spring:message code="view.profile.referenceFormType" /></label>
		<select id="referenceFormType">
			<option value="${ReferenceType.POSITIVE}">Positive</option>
			<option value="${ReferenceType.NEUTRAL}">Neutral</option>
			<option value="${ReferenceType.NEGATIVE}">Negative</option>
		</select>
		<label for="referenceFormDescription"><spring:message code="view.profile.referenceFormDescription" /></label>
		<input id="referenceFormDescription" />
		<button id="referenceFormConfirm">Confirm</button>
	</section>
	<section id="references">
		<h4>References</h4>
		<div id="referencesList"></div>
	</section>
</body>
</html>