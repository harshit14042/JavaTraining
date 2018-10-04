<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.html" %>
<div>
	<ol>
		<li><a href="addCustomer.jsp">Add Customer</a></li>
		<li><a href="customer">Show Customers</a></li>
		<li><a href="logout.jsp">LogOut</a></li>
	</ol>
</div>
<jsp:include page="login.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>