<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<sec:authentication property="principal" var="user"/>
	<h2>${ user.username }'s Profile</h2>
	<h4>Photos, home, and more info about ${ user.username } here.</h4>
	<button type="button">Send Request</button>
	<button type="button">Leave Reference</button>
	<p>
		<a href="<spring:url value='/logout' />">Log out</a>
	</p>
</body>
</html>