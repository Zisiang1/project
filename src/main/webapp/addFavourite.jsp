<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Add Favourite Book </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/ProductServlet/home"
				class="nav-link">Back to home</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form method="post">
					<label>Title</label> <input type="text" name="title" readonly value = "${product.title}"> <br>
					<label>Author</label> <input type="text" name="author" readonly value = "${product.author}"> <br>
					<label>Name</label> <input type="text" name="name" readonly value = "${user.name}"> <br>
					<input type="submit" value="Add Favourites">
				</form>
			</div>
		</div>
	</div>
</body>
</html>