<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#header{
	background-color:red;
}
</style>
</head>
<body>
<div>
	<div id="header"><%@ include file="header.html" %></div>
	<div><jsp:include page="showReviews.jsp"></jsp:include></div>
	<div><jsp:include page="footer.jsp"></jsp:include></div>
</div>
</body>
</html>