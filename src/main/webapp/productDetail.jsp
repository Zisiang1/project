<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> User Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/ProductServlet/home"
				class="nav-link">Back to home</a></li>
		</ul>
	</nav>

	<!-- Add to cart form -->
	<form method="post">
		<p>
			Title: <input readonly="readonly" value="${product.title}"
				name="title" />
		</p>

		<p>
			Image: <input readonly="readonly" value="${product.image}" name="img" />
		</p>

		<p>
			Price: <input readonly="readonly" value="${product.price}"
				name="price" />
		</p>

		<label for="quantity">Quantity:</label> <input type="number"
			id="quantity" name="quantity" min="1" max="10"> <input
			type="submit" value="Add To Cart" />
	</form>

	<br>
	<br>

	<!-- Add review form-->
	<form method="post">
		<p>
			Title: <input readonly="readonly" value="${product.title}"
				name="title" />
		</p>

		<p>
			Reviews: <input name="reviews" />
		</p>

		<p>
			Ratings: <input name="ratings" />
		</p>


		<input type="submit" value="Add Review" />
	</form>

	<p>
		<c:out value="${review.book}" />
	</p>
	<h1>
		<c:out value="${review.reviews}" />
	</h1>
	<p>
		<c:out value="${review.book}" />
	</p>

	<!-- <form>
		<label for="quantity">Quantity:</label> 
		<input type="number" id="quantity" name="quantity" min="1" max="10">
		<input type="submit">
	</form> -->
</body>
</html>