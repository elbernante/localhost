<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="search.view.title" /></title>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<spring:url value="/resources/js/search.js" />"></script>
</head>
<body>
	<header>
		<sec:authentication property="principal" var="user"/>
		<h2><spring:message code="search.view.title" /></h2>
		<h4>Search user profiles here.</h4>
	</header>
	<nav>
		<button type="button" id="dashboard"><spring:message code="search.view.dashboard" /></button>
		<a href="<spring:url value='/logout' />">Log out</a>
	</nav>
	<section id="userForm">
		<h4><spring:message code="search.view.userFormTitle" /></h4>
		<label for="userFormCity"><spring:message code="search.view.userFormCity" /></label>
		<input id="userFormCity" />
		<label for="userFormState"><spring:message code="search.view.userFormState" /></label>
		<input id="userFormState" />
		<label for="userFormCountry"><spring:message code="search.view.userFormCountry" /></label>
		<input id="userFormCountry" />
		<button id="userFormConfirm"><spring:message code="search.view.userFormConfirm" /></button>
	</section>
	<section id="users">
		<h4><spring:message code="search.view.users" /></h4>
		<div id="userList"></div>
	</section>
</body>
</html>