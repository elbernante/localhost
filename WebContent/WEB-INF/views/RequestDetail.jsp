<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css" />" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Request</title>
</head>
<body>
<h1> About Request</h1>

<form:form  action="requestview" modelAttribute="request" method="post">
   <div >
       	<p>User Name:<form:input  path="guest.firstName" value="${guest.firstName}"/></p>
        <p>Arrival Date: <form:input  path="arrivalDate" value="${arrivalDate}"/> </p>
         <p>Arrival Date:  <form:input  path="departureDate" value="${departureDate}"/><p>
         <p> Arrival Date:  <form:input  path="sendMessage" value="${sendMessage}"/><p></p>
        <form:textarea  path="responseMessage" rows = "4"/>
<%--    <form:select path="reqStatus">
                <form:options items="${status}" />
       </form:select>  --%>
  
      <input type="submit" id="btnSend" class="btn btn-primary" value ="Send Response"/>
       </div>
      </form:form>
</body>
</html>