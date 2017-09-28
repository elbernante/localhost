<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
<title>Insert title here</title>
</head>
<body>
	<form:form  modelAttribute="about" method="post" action="aboutme">
		<dl>
			<dt><label>Hosting Availability</label> </dt>
			<dd> 
  				<form:select path="hostAvaliable">
   					 <form:options items="${hostAvaliableList}" />
				</form:select>
  			</dd>

		</dl>
		<dl>
			<dt><label for="grewUp">Where I Grew up</label></dt>
			<dd><form:input id="grewUp" path="grewUp" type="text" /></dd>
			<dt><label for="occupation">Occupation</label></dt>
			<dd><form:input id="occupation" path="occupation" type="text" /></dd>
			<dt><label for="education">Education</label></dt>
			<dd><form:input id="education" path="education" type="text" /></dd>			
			
		</dl>
		<dl>
			<dt><label>Languages I'm Fluent In</label></dt>
			<dd><ul>
				<li><form:checkbox  id="English" name="languages" value="English" path="languages"/>English</li>
				<li><form:checkbox  id="Chinese" name="languages" value="Chinese" path="languages"/>Chinese</li>
				<li><form:checkbox  id="Amharic" name="languages" value="Amharic" path="languages"/>Amharic</li>
				<li><form:checkbox  id="Korean"  name="languages" value="Korean"  path="languages"/>Korean</li>
				</ul>
			</dd>
				
		</dl>
		<dl>
			<dt><label for="user_profile_about_me">About Me</label></dt>
			<dd><form:textarea id="user_profile_about_me" path="aboutMe" rows="5" cols="30"/></dd>	
		</dl>
		<dl>
			<dt></dt>
				
			<dd><input type="submit" id="btnSave" value="Save" /></dd>
		</dl>
	</form:form>

</body>
</html>