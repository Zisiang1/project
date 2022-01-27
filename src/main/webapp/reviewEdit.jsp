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

	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${review != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${review == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${review != null}">Update Review</c:if>
						<c:if test="${review == null}">Add New User</c:if>
					</h2>
				</caption>
				<c:if test="${review != null}">
					<input type="hidden" name="oriID" value="<c:out value='${review.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>ID</label> 
					<input readonly type="text" value="<c:out value='${review.id}' />" class="form-control" name="id" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Username</label> 
					<input readonly type="text" value="<c:out value='${review.username}' />" class="form-control" name="username">
				</fieldset>
				<fieldset class="form-group">
					<label>Reviews</label> 
					<input type="text" value="<c:out value='${review.reviews}' />" class="form-control" name="reviews">
					
				</fieldset>
				<fieldset class="form-group">
					<label> Ratings</label> 
					<input type="text" value="<c:out value='${review.ratings}' />" class="form-control" name="ratings">
				</fieldset>
				<fieldset class="form-group">
					<label> Book</label> 
					<input readonly type="text" value="<c:out value='${review.book}' />" class="form-control" name="book">
				</fieldset>
				<fieldset class="form-group">
					<label> Book ID</label> 
					<input readonly type="text" value="<c:out value='${review.bookid}' />" class="form-control" name="bookid">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>