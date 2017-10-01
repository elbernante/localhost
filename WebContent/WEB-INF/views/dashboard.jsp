<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
	<sec:authentication property="principal" var="user" />
	<h2><spring:message code="dashboard.view.welcome" /> ${user.username}!</h2>
</div>
<div class="row">
	<div class="col-30">
		<div class="profile-pic-placholder">
			<img class="profile-image-sm" alt="prrofile image" src="<spring:url value='/resources/images/user.png' />" />
		</div>
		<div>
			<a class="btn btn-menu"  href="<spring:url value='/search/getForm' />"><spring:message code="dashboard.view.search" /></a>
			<a class="btn btn-menu"  href="<spring:url value='/profile/${ user.username }' />"><spring:message code="dashboard.view.myprofile" /></a>
			<a class="btn btn-menu" href="<spring:url value='/itinerary' />"><spring:message code="dashboard.view.planATrip" /></a>
			<a class="btn btn-menu" href="<spring:url value='/viewRequest' />"><spring:message code="dashboard.view.requests" /></a>
		</div>
	</div>
	<div class="col-70">
		<div class="panel">
			<h4><spring:message code="dashboard.view.upcomingTrips" /></h4>
			<div id="trip-list"><spring:message code="dashboard.view.retrievingTrips" /></div>
		</div>
		<div class="panel">
			<h4><spring:message code="dashboard.view.travelersToMyCity" /></h4>
			<div id="traveler-list"><spring:message code="dashboard.view.noTravelers" /></div>
		</div>
		<div class="panel">
			<h4><spring:message code="dashboard.view.eventInMyArea" /></h4>
			<div id="traveler-list"><spring:message code="dashboard.view.noEvents" /></div>
		</div>
	</div>
</div>
