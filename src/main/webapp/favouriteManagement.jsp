<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Favourites List</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/addFavourite.jsp"
					class="btn btn-success">Add Favourites </a>
			</div>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="favourites" items="${listFavourites}">
						<tr>
							<td><c:out value="${favourites.title}" /></td>
							<td><c:out value="${favourites.author}" /></td>
							<td><c:out value="${favourites.name}" /></td>
							<td>
							<a href="delete?title=<c:out value="${favourites.title}"/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>