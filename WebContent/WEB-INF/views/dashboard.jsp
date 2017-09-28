<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<spring:url value="/resources/js/dashboard.js" />"></script>
</head>
<body>
	<header>
		<sec:authentication property="principal" var="user"/>
		<h2>Welcome ${user.username} !!!</h2>
		<h4>User's home dashboard goes here.</h4>
		<p>Add whatever interesting things you like here (e.g. travelers to your city, events nearby, search functions, etc...)</p>
	</header>
	<nav>
		<a href="<spring:url value='/profile/${ user.username }' />">My Profile</a>
		<button type="button" id="search"><spring:message code="dashboard.view.search" /></button>
		<a href="<spring:url value='/itinerary' />">Plan a Trip</a>
		<a href="<spring:url value='/viewRequest' />">Requests</a>
		<a href="<spring:url value='/logout' />">Log out</a>
	</nav>
	<section id="">
		
	</section>
</body>
</html>