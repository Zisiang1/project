<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <h1 class="font-weight-bold text-center">Register Page</h1>
<br>
<div class="card">
  <br>
  <form action="RegisterServlet"method="post" >
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputEmail4" class="font-weight-bold">email</label>
        <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Email" required>
        

 

      </div>
      <div class="form-group col-md-6">
        <label for="inputPassword4" class="font-weight-bold">Password</label>
        <input type="password" class="form-control" name="password" id="inputPassword4"
          placeholder="Password">
        <small id="passwordHelpBlock" class="form-text text-muted">
          Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special
          characters, or emoji.
        </small>
      </div>
    </div>
    <div class="form-group">
      <label for="inputUsername" class="font-weight-bold">Username</label>
      <input type="text" class="form-control" id="inputUsername" name="name" placeholder="Username">
      
    </div>
    <div class="form-group">
      <label for="inputAddress" class="font-weight-bold">Address</label>
      <input type="text" class="form-control" id="inputAddress" name="address" placeholder="1234 Main St">
      
    </div>
    <div class="form-group">
      <label for="inputAddress2" class="font-weight-bold">Address 2</label>
      <input type="text" class="form-control" id="inputAddress2" name="address2"
        placeholder="Apartment, studio, or floor">
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputCity" class="font-weight-bold">City</label>
        <input type="text" class="form-control" name="city" id="inputCity">
        
      </div>
      <div class="form-group col-md-4">
        <label for="inputState" class="font-weight-bold">State</label>
        <input type="text" class="form-control" id="inputState" name="state"
          placeholder="Which State You Live In">
          
      </div>
      <div class="form-group col-md-2">
        <label for="inputZip" class="font-weight-bold">Zip</label>
        <input type="number" class="form-control" name="zip" id="inputZip">
        
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputPhone" class="font-weight-bold">Phone No</label>
        <input type="text" class="form-control" name="phone" id="inputPhone">
        
      </div>
      <div class="form-group col-md-4">
        <label for="inputState" class="font-weight-bold">Date Of Birth</label>
        <input type="date" class="form-control" id="inputDate" name="date" placeholder="">
       
      </div>
   
    </div>
<br>
    <div class="text-center">
        
      
      
      <div class="row">
        <div class="col-12">
          <p><button class="btn btn-outline-primary col-3" type="submit" >Register</button>
        </div>
      </div>
    </div>
</form>
  
</div>
</html>