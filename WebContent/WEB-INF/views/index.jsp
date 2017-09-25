<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LocalHost</title>
</head>
<body>

	<h1>LocalHost</h1>
	<hr />
	<h4>See the world through the eyes of a local</h4>
	<p>
		<spring:message code="greeting" text="Greetings" /> ${ sampleModel.name }!
	</p>
</body>
</html>