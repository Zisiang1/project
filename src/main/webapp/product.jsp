<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Home</title>
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
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/FavouriteServlet/dashboard">Favourites</a>
				</li>
				<li class="nav-item"><a id="cart" class="nav-link"
					href="<%=request.getContextPath()%>/CartServlet/cart">Cart</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>


	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<!-- <a href="<%=request.getContextPath()%>/register.jsp"
					class="btn btn-success">Add New User</a>  -->
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>title</th>
						<th>author</th>
						<th>description</th>
						<th>genre</th>
						<th>image</th>
						<th>price</th>			
						<th>link</th>
						<th>Add to Favorite</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop -->
				<tbody>
					<c:forEach var="product" items="${listProduct}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.title}" /></td>
							<td><c:out value="${product.author}" /></td>
							<td><c:out value="${product.description}" /></td>
							<td><c:out value="${product.genre}" /></td>
							<td><c:out value="${product.image}" /></td>
							<td><c:out value="${product.price}" /></td>							
							<td><a href="productDetail?id=<c:out value="${product.id}"/>">To product detail</a></td>
							<td><a href="addFavourite?id=<c:out value="${product.id}"/>">Add to Favorite</a></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<!-- <td><a href="edit?name=<c:out value='${user.name}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out value='${user.name}' />">Delete</a></td>  -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
