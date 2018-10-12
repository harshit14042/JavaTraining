<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<form:form action="addBook" method="post">
	
	<label for="">Book Number</label>
	<form:input path="bookNumber"/>
	<form:errors cssStyle="color:red" path="bookNumber"></form:errors>
	
	<label for="">Book Name</label>
	<form:input path="bookName"/>
	
	<label for="">Author</label>
	<form:input path="author"/>
	
	<label for="">Category</label>
	<form:select items="${catList}" path="category"></form:select>
	
	<label for="">Date of Publish</label>
	<form:input path="dateOfPublish" type="date"/>
	<form:errors cssStyle="color:red" path="dateOfPublish"></form:errors>
	
	<label for="">Rate Per Unit</label>
	<form:input path="ratePerUnit"/>
	
	<input type="submit" value="ADD"/>
	
</form:form>
</body>
</html>