<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="add" method="post">

<label for="">Name</label>
<form:input path="name"/>

<label for="">Description</label>
<form:input path="description"/>

<label for="">Continent</label>
<form:select items="${continentList}" path="continent"></form:select>
Modern:<form:radiobutton value="Modern" path="type"/>
Ancient<form:radiobutton value="Ancient" path="type"/>

<input type="submit" value="Submit"/>
</form:form>
</body>
</html>