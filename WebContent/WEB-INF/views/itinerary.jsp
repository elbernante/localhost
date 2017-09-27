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
		<div>
			<button>Add a Destination</button>
		</div>
	</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="<spring:url value='/resources/lib/jquery/jquery-3.2.1.min.js' />"><\/script>');</script>
	<script src="<spring:url value='/resources/js/itinerary.js' />"></script>
</body>
</html>