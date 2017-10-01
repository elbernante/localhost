<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="almost-fullscreen">
	<div class="center-tile shadowed-box signin-box">
		<img height="100" width="100" alt="logo" src="<spring:url value='/resources/images/localhost.png' />">
		<h1>LocalHost</h1>
		<h3 class="panel-title">Please sign in</h3>
		<c:if test="${not empty error}">
			<div class="error-message">
				<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
			</div>
		</c:if>
		<form action="<spring:url value="/login"></spring:url>" method="post">
				Username: <input name='username' type="text" /><br /> 
				Password: <input name='password' type="password" /><br /><br />
				<input class="btn btn-primary" type="submit" value="Login" />
		</form>
	</div>
</div>