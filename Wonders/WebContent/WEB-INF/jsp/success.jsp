<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="resources/images/${command.name}.jpg">
<h1>${command.name}</h1><br/>
Desc: <p>${command.description}</p><br/>
Continent: <p>${command.continent}</p>
Type: <p>${command.type}</p>
</body>
</html>