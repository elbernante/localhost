<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
<title>LocalHost</title>
</head>
<body>
	<tiles:insertAttribute name="navigation" />
	<div class="content-wrapper">
		<div class="content">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="<spring:url value='/resources/lib/jquery/jquery-3.2.1.min.js' />"><\/script>');</script>
	<c:set var="jsinclude"><tiles:getAsString name="jsinclude" /></c:set>			
	<script src="<spring:url value='${ jsinclude }' />"></script>
</body>
</html>