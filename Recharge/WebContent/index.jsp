<%@page import="javax.servlet.http.*,java.util.*,java.util.stream.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function change(){
	
	//alert("Hello"+document.getElementById("plan"));
	
	if(parseInt(document.getElementById("plan").value)==1){
	document.getElementById("amount").innerHTML="100";
	}
	else if(parseInt(document.getElementById("plan").value)==2){
		document.getElementById("amount").innerHTML="200";
	}
	else if(parseInt(document.getElementById("plan").value)==3){
		document.getElementById("amount").innerHTML="300";
	}
	else if(parseInt(document.getElementById("plan").value)==4){
		document.getElementById("amount").innerHTML="400";
	}
	else{
		document.getElementById("amount").innerHTML="500";
	}
}
</script>
<style>
.left{
float:left;
margin-left:70px;
}
.right{
margin-left:400px;
}
table,td{
border: 1px solid black;
}
</style>
<body>
<%!String mobileNumber="";Integer plan=1; %>

<%
	Cookie[] cks=request.getCookies();

	List<Cookie> list=Arrays.asList(cks);
	if(list.size()>1){
		List<String> ckyName=list.stream().filter(cky -> cky.getName().equals("mobileNumber")).map(cky->cky.getValue()).collect(Collectors.toList());
	
		if(ckyName.size()>0){
			mobileNumber=ckyName.get(0);
		}
		else{
			mobileNumber="";
		}
		
		ckyName=list.stream().filter(cky -> cky.getName().equals("plan")).map(cky->cky.getValue()).collect(Collectors.toList());
		if(ckyName.size()>0){
			plan=Integer.parseInt(ckyName.get(0));
		}
	}
%>
<div class="left">
	<%@include file="planList.html" %>
</div>
<form action="Success.jsp">
<div class="right">
	<h1>Recharge</h1>
	<label for="mobileNumber">Mobile Number</label>
	<input type="text" id="mobileNumber" name="mobileNumber" required="required" value="<%=mobileNumber%>"/>
	<label for="plan">Plan</label>
	<select name="plan" id="plan" onchange="change()">
		<option value="1" <%if(plan==1)out.println("selected");%>>Plan 1</option>
		<option value="2" <%if(plan==2)out.println("selected");%>>Plan 2</option>
		<option value="3" <%if(plan==3)out.println("selected");%>>Plan 3</option>
		<option value="4" <%if(plan==4)out.println("selected");%>>Plan 4</option>
		<option value="5" <%if(plan==5)out.println("selected");%>>Plan 5</option>
	</select>
	<br/>
	<b>Amount:</b><p id="amount"><%out.print(plan*100);%></p>
	<input type="submit" value="Recharge"/>
</div>
</form>
</body>
</html>