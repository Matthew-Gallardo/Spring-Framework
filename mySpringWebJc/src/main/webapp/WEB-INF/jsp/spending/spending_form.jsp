<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Spending Page</h1>
<form:form modelAttribute="form3" method="POST">
 	Food: <form:input path="food" /> <form:errors path="food" /><br/>
    Clothing: <form:input path="clothing" /> <form:errors path="clothing" /><br/>
    Entertainment: <form:input path="entertainment" /> <form:errors path="entertainment" /><br/>
    Rent: <form:input path="rent" /> <form:errors path="rent" /><br/>
    <input type="submit" value="Calculate Spending" />
</form:form>

</body>
</html>