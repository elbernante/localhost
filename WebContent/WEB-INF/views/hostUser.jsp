<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Request</title>
</head>
<body>
<h1> List of Request</h1>
<%-- <form:form modelAttribute="requests" action="viewRequest" method="post">  --%>
<h1> ${NoRequest} </h1>
<table>
    <c:forEach var="request" items="${requests}">
 
     <tr> <td>User Name: </td><td> ${request.guest.firstName}</td> 
       <td><a href="requestview?id=${request.id}">view Detail</a> </td>
     
        </tr>
    </c:forEach>  
    </table>
</body>
</html>