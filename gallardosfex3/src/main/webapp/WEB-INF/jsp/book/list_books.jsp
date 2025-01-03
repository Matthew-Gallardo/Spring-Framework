<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Books</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/list.css">
</head>
<body>
	<h1>List of Books</h1>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="book" items="${bookList}">
			<tr>
				<td><c:out value="${book.isbn}" /></td>
				<td><c:out value="${book.title}" /></td>
				<td><c:out value="${book.author}" /></td>
				<td><c:out value="${book.price}" /></td>
				<td><c:out value="${book.quantity}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/gallardoweb/app1/book/main">Back to main</a>
</body>
</html>
