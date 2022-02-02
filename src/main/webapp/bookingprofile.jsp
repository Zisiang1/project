<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

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
					href="<%=request.getContextPath()%>/CartServlet/cart">Cart</a></li>

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
			<h3 class="text-center">Booking Details For You</h3>
			<hr>

			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Book Id</th>
						<th>Name</th>
						<th>Book</th>
						<th>Image</th>
						<th>Paid</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Cost</th>
						<th>Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet response to a loop -->
				<tbody>
					<c:forEach var="cart" items="${listBooking}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${cart.id}" /></td>
							<td><c:out value="${cart.bookid}" /></td>
							<td><c:out value="${cart.username}" /></td>
							<td><c:out value="${cart.book}" /></td>
							<td><c:out value="${cart.img}" /></td>
							<td><c:out value="${cart.paid}" /></td>
							<td><c:out value="${cart.price}" /></td>
							<td><c:out value="${cart.quantity}" /></td>
							<td><c:out value="${cart.totalcost}" /></td>
							<td><c:out value="${carts.date}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a
								href="<%=request.getContextPath()%>/BookingServlet/delete?id=<c:out value='${cart.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	


</body>
</html>