<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="form1" method="POST">
		ID: <form:input path="id" /><form:errors path="id"/><br />
        FULLNAME: <form:input path="fullname" /><form:errors path="fullname"/><br />
        SALARY: <form:input path="salary" /><form:errors path="salary"/><br />
        BIRTHDAY: <form:input path="birthday" /><form:errors path="birthday"/><br />
		Color:  <form:radiobuttons path="color" items="${optColor}"/><br/>
		Gender: <form:select path="gender" items="${optGender}"/><br/>
		Foods: <form:checkboxes path="food" items="${optFood}"/><br/>
		<input type="submit" value="Add Profile"/> <br>
	</form:form>

</body>
</html>