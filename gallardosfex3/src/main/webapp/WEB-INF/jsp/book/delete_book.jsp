<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Delete Book</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/delete.css">
</head>
<body>
    <h2>Delete a Book</h2>

  <c:url var="submiturl" value="/app1/book/delete" />
	<form:form modelAttribute="bookForm" action="${submiturl}" method="POST">
        <div>
            <label for="title">Book Title:</label>
           <form:select path="title" id="title" required="true">
	                <form:options items="${recs}" itemValue="title" itemLabel="title" />
	       </form:select>
      
        </div>
        <div>
            <button type="submit">Delete Book</button>
        </div>
    </form:form>
</body>
</html>
