<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.training.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Contacts</title>
</head>
<body>

<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email ID</th>
		<th>Relation</th>
		<th>Numbers</th>
		<th>Actions</th>
	</tr>
<%

	Set<Contact> contactList=(Set<Contact>)request.getAttribute("contactList");
	
	for(Contact c:contactList){
%>

	<tr>
		<td><% out.println(c.getPerson().getFirstName());%></td>
		<td><% out.println(c.getPerson().getLastName());%></td>
		<td><% out.println(c.getPerson().getEmail());%></td>
		<td><% out.println(c.getRelation());%></td>
		<td>
		<select multiple="multiple">
			<% for(Long number:c.getPerson().getNumbers()){
				out.println(number);
				
			%>
			
				<option value="<% out.println(c.getPerson().getId()+" "+number); %>"></option>
			
			<% } %>
		</select>
		</td>
		<td>
		<form method="post" action="removeContact">
			<input type="submit" value="Remove">
			<% request.setAttribute("contactId", c.getContactId()); %>
		</form>
		<form method="post" action="removeNumbers">
			<input type="submit" value="Remove Numbers">
			<!-- <% request.setAttribute("contactId", c.getContactId()); %> -->
		</form>
		</td>
	</tr>
	<% } %>

</table>
<!--Person(PersonId,FirstName,LastName,email)
Contacts(ContactId,PersonId,relation)
ContactNumbers(PersonId,number);-->
<form method="post" action="viewCategoryWise">
	<input type="submit" value="View Contacts by Categories">
</form>
<a href="editContactForm.html"><input type="button" value="Edit Contact"></a>
<a href="addContactForm.html"><input type="button" value="Add Contact"></a>
</body>
</html>