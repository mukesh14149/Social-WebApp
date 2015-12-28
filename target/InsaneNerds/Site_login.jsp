<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	 <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<style>
		.btn-danger {  background-color: #DD4B39;}
		.btn-info {  background-color:  #3B5998;}
	</style>

</head>
<body>
	<div class="col-sm-4 sidenav"></div>
	<div class="w3-card-4 w3-green col-sm-4" style="height:35em; top:5em;">
    <div class="container col-sm-12" >
		<form class="form-signin"  action="/InsaneNerds/Normal_login" method="post">
        <h2 class="form-signin-heading">Please sign up</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control input-lg" name="emailid" placeholder="Email address" required autofocus><br>
        <label for="inputName" class="sr-only">Name</label>
        <input type="text" id="inputName" class="form-control input-lg" name="Name" placeholder="Name" required autofocus><br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control input-lg" name="password" placeholder="Password" required><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button><br>
     </form>
		</div> 
	</div>
	<div class="col-sm-4 sidenav"></div>
		

</body>
</html>