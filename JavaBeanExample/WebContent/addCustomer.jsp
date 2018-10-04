<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<%@include file="header.html" %>
<c:if test="${sessionScope.isLoggedIn}">
<form action="processCustomer.jsp" method="post">
	<div><label for="customerId">Customer Id</label><input type="text" name="customerId" id="customerId" required="required"/></div>
	<div><label for="customerName">Customer Name</label><input type="text" name="customerName" id="customerName" required="required"/></div>
	<div><label for="mobileNumber">Mobile Number</label><input type="text" name="mobileNumber" id="mobileNumber" required="required"/></div>
	<div><input type="submit" value="Add"/></div>
</form>
</c:if>
<c:if test="${!sessionScope.isLoggedIn}">
<c:out value="Not Logged In"></c:out>
<a href="index.jsp">Login Page</a>
</c:if>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>