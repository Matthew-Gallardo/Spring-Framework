<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile Details</h1>
	<p>ID <c:out value="${form.id}"/> </p>
	<p>Fullname <c:out value="${form.fullname}"/> </p>
	<p>Salary <c:out value="${form.salary}"/> </p>
	<p>Birthday <c:out value="${form.birthday}"/> </p>
	<p>Color <c:out value="${form.color}"/> </p>
	<p>Gender <c:out value="${form.gender}"/> </p>
	<p>Food 
	<c:forEach var="f" items="${form.food}">
		<p> <c:out value="${f}"/> </p>
	</c:forEach>
	
	</p>

</body>
</html>