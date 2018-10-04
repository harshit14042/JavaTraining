<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>Customer Id</td>
		<td>Customer Name</td>
		<td>Phone Number</td>
	</tr>
<c:forEach items="${requestScope.customers}" var="item">
	<tr>
		<td>${item.getCustomerId()}</td>
		<td>${item.getCustomerName()}</td>
		<td>${item.getMobileNumber()}</td>
	</tr>
</c:forEach>
</table>
<br/>
<a href="addCustomer.jsp">Add Another Customer</a>
</body>
</html>