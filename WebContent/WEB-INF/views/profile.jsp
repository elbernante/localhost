<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<spring:url value="/resources/js/localhost.js" var="mainJs" />
</head>
<body>
	<sec:authentication property="principal" var="user"/>
	<input type="hidden" id="username" value="${user.username}" />
	<h2>${ user.username }'s Profile</h2>
	<h4>Photos, home, and more info about ${ user.username } here.</h4>
	<button type="button">Send Request</button>
	<a href="<spring:url value='/addrequest'/>">Send Request</a>
	<button type="button">Leave Reference</button>
	<p>
		<a href="<spring:url value='/logout' />">Log out</a>
	</p>
	<div>
		<h4>References</h4>
		<div id="references"></div>
	</div>
</body>
</html>