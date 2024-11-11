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
<h1>Calculator Page</h1>
<form:form modelAttribute="form2" method="POST">
	Num1: <form:input path="operand1"/>	 <form:errors path="operand1" /> <br/>
	Operator: <form:select path="operator" items="${optOperator}"/> <br/>
	Num2: <form:input path="operand2"/> <form:errors path="operand2" /> <br/>
	<input type="submit" value="Calculate"/> <br>

</form:form>

</body>
</html>