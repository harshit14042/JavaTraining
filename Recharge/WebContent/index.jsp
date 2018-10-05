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
	document.getElementById("amount").innerHTML=400;
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
<div class="left">
	<%@include file="planList.html" %>
</div>
<form action="Success.jsp">
<div class="right">
	<h1>Recharge</h1>
	<label for="mobileNumber">Mobile Number</label>
	<input type="text" id="mobileNumber" name="mobileNumber" required="required"/>
	<label for="plan">Plan</label>
	<select name="plan" onchange="change">
		<option value="plan1">Plan 1</option>
		<option value="plan2">Plan 2</option>
		<option value="plan3">Plan 3</option>
		<option value="plan4">Plan 4</option>
		<option value="plan5">Plan 5</option>
	</select>
	<label for="amount">Amount</label>
	<p id="amount"></p>
	<input type="submit" value="Recharge"/>
</div>
</form>
</body>
</html>