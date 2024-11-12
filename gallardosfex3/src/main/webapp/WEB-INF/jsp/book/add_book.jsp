<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add.css">

</head>
<body>
	<c:url var="submiturl" value="/app1/book/entry" />
	<h1>Add New Book</h1>
	<form:form modelAttribute="bookForm" action="${submiturl}" method="POST">
		<label>ISBN:</label>
		<form:input path="isbn" /> <br/>

		<label>Title:</label>
		<form:input path="title" /> <br/>

		<label>Author:</label>
		<form:input path="author" /> <br/>

		<label>Price:</label>
		<form:input path="price" /> <br/>

		<label>Quantity:</label>
		<form:input path="quantity" /> <br/>

		<input type="submit" value="Add Book" />
	</form:form>
</body>
</html>
