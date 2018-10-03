<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You selected the following</h1>
<%
	Map<String,String[]> itemMap=(Map<String,String[]>)session.getAttribute("cart");
	
	Set<String> itemCategory=itemMap.keySet();
	
	for(String key:itemCategory){
%>
<b><% out.println(key); %></b>
<% for(String item:itemMap.get(key)){ %>
<p><% out.println(item); }%></p>
<%} %>
</body>
</html>