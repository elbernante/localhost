<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>About Me</title>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
</head>
<body>
	<form:form  modelAttribute="about"  enctype="multipart/form-data">
		<dl>
			<dt><label>Hosting Availability</label> </dt>
			<dd> <form:select  path="about.hostAvaliable">
    					 <form:options items="${listOfHostAvaliable}"></form:options>
  				</form:select>
  			</dd>
		</dl>
	</form:form>
</body>
</html>