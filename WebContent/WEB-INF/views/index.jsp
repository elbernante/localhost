<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>LocalHost</title>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
</head>
<body>
	<h1><img height="40" width="40" alt="logo" src="<spring:url value='/resources/images/localhost.png' />"> LocalHost</h1>
	<hr />
	<h4>See the world through the eyes of a local</h4>
	<p>
		<spring:message code="greeting" text="Greetings" /> ${ sampleModel.name }!
	</p>
	<a href="<spring:url value='/login'></spring:url>">Login</a>
	<a href="<spring:url value='profile/addProfile'></spring:url>">Register</a>
	
	
</body>
</html>