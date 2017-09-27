<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
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
	<a href="<spring:url value='/login'></spring:url>">Login</a>
</body>
</html>