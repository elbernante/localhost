<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="navbar">
	<div class="brand">
		<a href="<spring:url value='/' />">LocalHost</a>
	</div>
	<div class="tool-belt">
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="user"/>
			<a href="<spring:url value='/profile/${ user.username }' />" class="username">${ user.username }</a>
			<a href="<spring:url value='/logout' />"class="btn btn-primary">Log out</a>
		</sec:authorize>
	</div>
</div>