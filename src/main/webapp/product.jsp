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
<title>Insert title here</title>
</head>

<style>
/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>

<body>

<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#news">Profile</a>
  <a href="#contact">Login</a>
  <a href="#about">Sign Up</a>
</div>

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
						<th>link</th>
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
							<td><a href="">To product detail</a></td>
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