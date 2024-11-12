<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Result</title>
</head>
<body>
    <h1>Calculator Result</h1>
    <p>The result of calculating 
        <c:out value="${form.operand1}" /> 
        <c:out value="${form.operator}" /> 
        <c:out value="${form.operand2}" /> 
        is <c:out value="${form.result}" />.
    </p>
</body>
</html>
