
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> User Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProfileServlet/profile"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
					</c:if>
				<caption>
					<h2>
						<c:if test="${user != null}">
Edit User
</c:if>
						<c:if test="${user == null}">
Add New User
</c:if>
					</h2>
				</caption>
				
				<c:if test="${user != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${user.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out
value='${user.name}' />" class="form-control"
						name="Name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out
value='${user.password}' />" class="form-control"
						name="Password">
				</fieldset>
				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out
value='${user.email}'/>" class="form-control"
						name="Email">
				</fieldset>
				<fieldset class="form-group">
					<label>Date Of Birth</label> <input type="date"
						value="<c:out
value='${user.dateOfBirth}'/>" class="form-control"
						name="Date_Of_Birth">
				</fieldset>
				<fieldset class="form-group">
					<label>Phone Number</label> <input type="number"
						value="<c:out
value='${user.phoneNumber}'/>" class="form-control"
						name="Phone_Number">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out
value='${user.address}'/>" class="form-control"
						name="Address">
				</fieldset>
				<fieldset class="form-group">
					<label>Address2</label> <input type="text"
						value="<c:out
value='${user.address2}'/>" class="form-control"
						name="Address2">
				</fieldset>
				
				<fieldset class="form-group">
					<label>City</label> <input type="text"
						value="<c:out
value='${user.city}' />" class="form-control"
						name="City">
				</fieldset>
				<fieldset class="form-group">
					<label>State</label> <input type="text"
						value="<c:out
value='${user.state}'/>" class="form-control"
						name="State">
				</fieldset>
				<fieldset class="form-group">
					<label>Zip</label> <input type="text"
						value="<c:out
value='${user.zip}'/>" class="form-control"
						name="Zip">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
					</form>
				
				
			</div>
		</div>
	</div>
</body>
</html>