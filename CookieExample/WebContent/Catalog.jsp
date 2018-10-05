<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.*,java.util.*,java.util.stream.*,com.training.ItemList"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%!String bgColor;%>
<%

Cookie[] cks=request.getCookies();
List<Cookie> list=Arrays.asList(cks);
List<String> ckyName=list.stream().filter(cky -> cky.getName().equals("bgColor")).map(cky->cky.getValue()).collect(Collectors.toList());
if(ckyName.size()>0){
	bgColor=ckyName.get(0);
}
else{
	bgColor="#FFFFFF";
}


%>
<body style="background-color:<%out.println(bgColor);%>">
<%

	cks=request.getCookies();
	list=Arrays.asList(cks);
	ckyName=list.stream().filter(cky -> cky.getName().equals("searchedItem")).map(cky->cky.getValue()).collect(Collectors.toList());
	
	List<String> items=ItemList.getItems().get(ckyName.get(0));
	
	for(String s:items)
		out.println("<h1>"+s+"</h1>");
	
%>
<ul>
	<li>Electronics</li>
	<li>Textiles</li>
	<li>Books</li>
	<li>Fashion</li>
</ul>
</body>
</html>