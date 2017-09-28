<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="<spring:url value='/profile/myhome'/>">My Home</a> 
		<dl>
			<dt><label>Hosting Availability</label> </dt>
			<dd>${about.hostAvaliable}</dd>

		</dl>
		<dl>
			<dt><label for="grewUp">Where I Grew up</label></dt>
			<dd>${about.grewUp}</dd>
			<dt><label for="occupation">Occupation</label></dt>
			<dd>${about.occupation}</dd>
			<dt><label for="education">Education</label></dt>
			<dd>${about.education}</dd>			
			
		</dl>
		<dl>
			<dt><label>Languages I'm Fluent In</label></dt>
			<dd><ul>
				<c:forEach items="${about.languages}" var="language">
				<li>${language}</li>
				</c:forEach>
				</ul>
			</dd>
				
		</dl>
		<dl>
			<dt><label for="user_profile_about_me">About Me</label></dt>
			<dd>${about.aboutMe}</dd>	
		</dl>
		
</body>
</html>