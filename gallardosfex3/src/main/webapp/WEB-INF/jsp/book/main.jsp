<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bookstore Management System</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <c:set var="url" value="/gallardoweb/app1/book" />
    
    <h1>Bookstore Management</h1>
    <ul>
        <li><a href="${url}/entry">Insert Book</a></li>
        <li><a href="${url}/list">List Books</a></li>
        <li><a href="${url}/delete">Delete Book</a></li>
    </ul>
</body>
</html>
