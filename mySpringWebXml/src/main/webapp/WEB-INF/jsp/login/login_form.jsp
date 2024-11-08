<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${title}"/></title>
</head>
<c:url var="url" value="/app1/login/form.html"  />
<body>
	<h1><c:out value="${headerx}"/></h1>
	<form action="<c:out value="${url}"/>" method="POST">
		Username: <input type="text" name="username"/> <br/>
		Password: <input type="password" name="password"/> <br/>
		Birthday: <input type="date" name="birthday"/> <br/>
		 <input type="submit" value="Login"/> <br>
	</form>

</body>
</html>