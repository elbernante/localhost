<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> User from <%-- ${county} --%></h1>
<form:form modelAttribute="users"> 
<table>
    <c:forEach var="user" items="${users}">
    
     <tr> <td>User Name: </td><td> ${user.firstName}</td> 
       <td>
        <a href="addrequest?id=${user.id}">Send Request</a>
          </td>
        </tr>
    </c:forEach>  
    </table>
  <</form:form>
</body>
</html>