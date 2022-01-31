<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background: rgb(99, 39, 120)
}

.form-control:focus {
	box-shadow: none;
	border-color: #BA68C8
}

.profile-button {
	background: rgb(99, 39, 120);
	box-shadow: none;
	border: none
}

.profile-button:hover {
	background: #682773
}

.profile-button:focus {
	background: #682773;
	box-shadow: none
}

.profile-button:active {
	background: #682773;
	box-shadow: none
}

.back:hover {
	color: #682773;
	cursor: pointer
}

.labels {
	font-size: 11px
}

.add-experience:hover {
	background: #BA68C8;
	color: #fff;
	cursor: pointer;
	border: solid 1px #BA68C8
}
</style>

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

<br>


<div class="container rounded bg-white mt-5 mb-5" action="LoginServlet"
	method="post">
	<div class="row">

		<div class="col-md-3 border-right">
			<div
				class="d-flex flex-column align-items-center text-center p-3 py-5">
				<img class="rounded-circle mt-5" width="150px"
					src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
					class="font-weight-bold"><c:out value="${user.name}" /></span><span
					class="text-black-50"><c:out value="${user.email}" /></span><span>
				</span>
			</div>
		</div>
		<div class="col-md-9 border-right">
			<div class="p-3 py-5">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h4 class="text-right">Profile Settings</h4>
				</div>
				<div class="row mt-2">
					<div class="col-md-6">
						<label class="labels">Name</label><input type="text"
							value="${user.name}" class="form-control">
					</div>
					<div class="col-md-6">
						<label class="labels">Phone Number</label><input type="text"
							class="form-control" value="${user.phoneNumber}"
							placeholder="surname">
					</div>
				</div>
				<div class="row mt-3">

					<div class="col-md-12">
						<label class="labels">Address Line 1</label><input type="text"
							class="form-control" value="${user.address}"
							placeholder="enter address line 1" value="">
					</div>
					<div class="col-md-12">
						<label class="labels">Address Line 2</label><input type="text"
							class="form-control" value="${user.address2}"
							placeholder="enter address line 2" value="">
					</div>
					<div class="col-md-12">
						<label class="labels">Postcode</label><input type="text"
							class="form-control" value="${user.zip}" value="">
					</div>

					<div class="col-md-12">
						<label class="labels">Email</label><input type="text"
							class="form-control" value="${user.email}"
							placeholder="enter email id" value="">
					</div>

				</div>
				<div class="row mt-3">
					<div class="col-md-6">
						<label class="labels">Country</label><input type="text"
							class="form-control" value="${user.city}" placeholder="country"
							value="">
					</div>
					<div class="col-md-6">
						<label class="labels">State/Region</label><input type="text"
							class="form-control" value="${user.state}" value=""
							placeholder="state">
					</div>
				</div>
				<div class="mt-5 text-center">
					<a href="<%=request.getContextPath()%>/ProfileServlet/edit"><button
							class="btn btn-primary profile-button" type="button">Update
							Profile</button></a>
				</div>
				<div class="mt-5 text-center">
					<a href="<%=request.getContextPath()%>/ProfileServlet/delete"><button
							class="btn btn-primary profile-button" type="button">Delete
							Account</button></a>
				</div>
			</div>
		</div>

	</div>
</div>
</html>