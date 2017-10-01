<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="almost-fullscreen">
	<div class="center-tile shadowed-box welcome-box">
		<img height="100" width="100" alt="logo" src="<spring:url value='/resources/images/localhost.png' />">
		<h1>LocalHost</h1>
		<h4>See the world through the eyes of a local</h4>
		<a class="btn btn-primary" href="<spring:url value='/login'></spring:url>">Login</a>
		<a class="btn btn-primary" href="<spring:url value='/profile/addProfile'></spring:url>">Register</a>
	</div>
</div>