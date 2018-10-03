<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.training.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" class="table table-striped">
	<tr>
		<td>MovieId</td>
		<td>MovieName</td>
		<td>Genre</td>
		<td>Director</td>
		<td>Rating</td>
	</tr>
<%
	List<Movie> movieList=(List<Movie>)request.getAttribute("movieList");
	for(Movie movie:movieList){
%>

<tr>
	<td><% out.println(movie.getMovieId());%></td>
	<td><% out.println(movie.getMovieName()); %></td>
	<td><% out.println(movie.getGenre()); %></td>
	<td><% out.println(movie.getDirector()); %></td>
	<td><% out.println(movie.getRating()); %></td>
</tr>
<%
	}
%>
</table>
</body>
</html>