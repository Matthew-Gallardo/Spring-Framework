<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spending Result</title>
</head>
<body>
<h1>Spending Breakdown</h1>
<table border="1">
    <tr>
        <th>Category</th>
        <th>Budget</th>
    </tr>
    <tr>
        <td>Food</td>
        <td><c:out value="${form.foodPercentage}" />%</td>
    </tr>
    <tr>
        <td>Clothing</td>
        <td><c:out value="${form.clothingPercentage}" />%</td>
    </tr>
    <tr>
        <td>Entertainment</td>
        <td><c:out value="${form.entertainmentPercentage}" />%</td>
    </tr>
    <tr>
        <td>Rent</td>
        <td><c:out value="${form.rentPercentage}" />%</td>
    </tr>
</table>
</body>
</html>
