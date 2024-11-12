<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <c:url var="cssPath" value="/app1/css/add.css" />
    <link rel="stylesheet" type="text/css" href="${cssPath}"/>
    <meta charset="ISO-8859-1">
    <title>Project Form</title>
</head>
<body>
    <c:url var="submiturl" value="/app1/hrms/project/form.html" />
    <h1>Project Form Entry</h1>
    <form:form modelAttribute="projForm" action="${submiturl}" method="POST">
        Project ID <form:input path="id" /> <br/>
        Project Name <form:input path="projectname" /> <br/>
        Project Date <form:input path="projectdate" /> <br/>
        <input type="submit" value="Add Project"/><br/>
    </form:form>
</body>
</html>
