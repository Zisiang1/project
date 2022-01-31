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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/ProductServlet/home">Home<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/ProductServlet/reviews">Reviews</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/ProfileServlet/profile">Profile</a>
				</li>
				<!-- Add To Favourite -->
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/FavouriteServlet/dashboard">Favourites</a>
				</li>

			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<br>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">Favourites List</h3>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="favourites" items="${listFavourites}">
						<tr>
							<td><c:out value="${favourites.title}" /></td>
							<td><c:out value="${favourites.author}" /></td>
							<td><a
								href="delete?title=<c:out value="${favourites.title}"/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>