<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table>
<tr><td><c:out value="${bookAdded.bookNumber}"></c:out></td>
<td><c:out value="${bookAdded.bookName}"></c:out></td>
<td><c:out value="${bookAdded.author}"></c:out></td>
<td><c:out value="${bookAdded.category}"></c:out></td>
<td><c:out value="${bookAdded.dateOfPublish}"></c:out></td>
<td><c:out value="${bookAdded.ratePerUnit}"></c:out></td></tr>
</table>
</body>
</html>