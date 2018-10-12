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
<tr><td><c:out value="${command.bookNumber}"></c:out></td>
<td><c:out value="${command.bookName}"></c:out></td>
<td><c:out value="${command.author}"></c:out></td>
<td><c:out value="${command.category}"></c:out></td>
<td><c:out value="${command.dateOfPublish}"></c:out></td>
<td><c:out value="${command.ratePerUnit}"></c:out></td></tr>
</table>
</body>
</html>