<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.training.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    text-align: left;
    border: none;
    outline: none;
    transition: 0.4s;
}

/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
.active, .accordion:hover {
    background-color: #ccc;
}

/* Style the accordion panel. Note: hidden by default */
.panel {
    padding: 0 18px;
    background-color: white;
    display: none;
    overflow: hidden;
}
</style>
<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
        /* Toggle between adding and removing the "active" class,
        to highlight the button that controls the panel */
        this.classList.toggle("active");

        /* Toggle between hiding and showing the active panel */
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    });
}</script>
</head>
<body>
<% 
	TreeSet<Contact> friends=(TreeSet<Contact>)request.getAttribute("friendList");
	TreeSet<Contact> relatives=(TreeSet<Contact>)request.getAttribute("relativeList");
	TreeSet<Contact> office=(TreeSet<Contact>)request.getAttribute("officeList");
%>
<button class="accordion">Friends</button>
<div class="panel">
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Numbers</th>
		</tr>
		<%
			for(Contact c: friends){
		%>
		<tr>
			<td><% out.println(c.getPerson().getFirstName()); %></td>
			<td><% out.println(c.getPerson().getLastName()); %></td>
			<td><% out.println(c.getPerson().getEmail()); %></td>
			<td>
			<% for(Long num:c.getPerson().getNumbers()){
			out.println(num);
			}%>
			</td>
		</tr>
		<%}%>
	</table>
</div>

<button class="accordion">Relatives</button>
<div class="panel">
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Numbers</th>
		</tr>
		<%
			for(Contact c: relatives){
		%>
		<tr>
			<td><% out.println(c.getPerson().getFirstName()); %></td>
			<td><% out.println(c.getPerson().getLastName()); %></td>
			<td><% out.println(c.getPerson().getEmail()); %></td>
			<td>
			<% for(Long num:c.getPerson().getNumbers()){
			out.println(num);
			}%>
			</td>
		</tr>
		<%}%>
	</table>
</div>

<button class="accordion">Office</button>
<div class="panel">
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Numbers</th>
		</tr>
		<%
			for(Contact c: office){
		%>
		<tr>
			<td><% out.println(c.getPerson().getFirstName()); %></td>
			<td><% out.println(c.getPerson().getLastName()); %></td>
			<td><% out.println(c.getPerson().getEmail()); %></td>
			<td>
			<% for(Long num:c.getPerson().getNumbers()){
			out.println(num);
			}%>
			</td>
		</tr>
		<%}%>
	</table>
</div>

</body>
</html>