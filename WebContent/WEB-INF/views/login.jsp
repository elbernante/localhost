<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login | LocalHost</title>
</head>
<body>
	<h3 class="panel-title">Please sign in</h3>
	<c:if test="${not empty error}">
		<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
	</c:if>
	<form action="<spring:url value="/login"></spring:url>" method="post">
		<fieldset>
			User name: <input name='username' type="text" /><br /> 
			Password: <input name='password' type="password" /><br />
			<input type="submit" value="Login" />
		</fieldset>
		<security:csrfInput />
	</form>
</body>
</html>