<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Login</h2>
        
        <div class="card my-5">

 

          <form class="card-body cardbody-color p-lg-5"action="LoginServlet"method="post">

 

            <div class="text-center">
              <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                width="200px" alt="profile">
            </div>

 

            <div class="mb-3">
              <input type="text" class="form-control" id="Username" aria-describedby="emailHelp"
                placeholder="UserName"name="username">
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" placeholder="password"name="password">
            </div>
            <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button></div>
            <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not
              Registered? <a href="<%=request.getContextPath()%>/register.jsp" class="text-dark fw-bold"> Create an
                Account</a>
            </div>
          </form>
        </div>

 

      </div>
    </div>
  </div>
</body>
</html>
<style>
.btn-color{
  background-color: #0e1c36;
  color: #fff;
  
}

 

.profile-image-pic{
  height: 200px;
  width: 200px;
  object-fit: cover;
}

 

 

.cardbody-color{
  background-color: #ebf2fa;
}

 

a{
  text-decoration: none;
}
</style>