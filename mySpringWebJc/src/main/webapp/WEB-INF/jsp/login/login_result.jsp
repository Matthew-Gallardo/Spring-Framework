<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> <c:out value="${title}"></c:out> </title>
</head>
<body>
	<h1>Login Details</h1>
	<p>Username: <c:out value="${username}"/></p>
	<p>Password: <c:out value="${password}"/></p>
	<p>Birthday: <c:out value="${birthday}"/></p>
	
</body>
</html>