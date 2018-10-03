<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-3">
<form class="form" action="ProcessRating.jsp">
	<div class="form-group">
		<label for="movieName">movie Name</label>
		<input type="text" name="movieName" id="movieName" class="form-control"/>
	</div>
	
	<div class="form-group">
		<label for="rating">Rating</label>
		<input type="number" name="rating" id="rating" max="5" min="1" step="0.1" class="form-control"/>
	</div>
	<input type="submit" value="Submit" class="btn btn-danger"/>
</form>
</div>
</body>
</html>