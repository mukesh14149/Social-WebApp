<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
	    
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="../../favicon.ico">
	
	    
	    <title>InsaneNerds</title>
	
	   	<!-- bootstrap css and Js -->
	   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		
		
		<style>
			.btn-danger {  background-color: #DD4B39;}
			.btn-info {  background-color:  #3B5998;}
		</style>
	
	</head>


	<body>
		<%@ page import="java.io.*"
		import="java.util.*"
		import="javax.servlet.*"
		import="org.apache.tomcat.jni.File"
		%>
		<%
			HttpSession sess=request.getSession();
			String Name=(String) sess.getAttribute("Name");
			String confirm=(String) sess.getAttribute("confirm");
		    
		%>
		<%	//Check whether user is login or not by getting name value from session.
			if(Name==null || confirm!=null) { 
				if(Name==null){%>
		
		<%	}
				//if name is not null check whether sign in user has confirm his/her mail or not.
				else {%>
		<h2>Hello <%=Name %> you need to confirm your mail and sign in again to get access</h2>
				<%}sess.invalidate(); 
				//below form come in each case.
				%>
		
		
		<!--left nav-bar start -->
	 	<div class="col-sm-4 sidenav">
	 			<% if(Name==null){%><h2>Hello World!</h2><%} %>
	 	</div>
	 	<!-- left nav-bar end -->
	 	
	 	
	 	<!--Middle nav-bar start -->
		<div class="w3-card-4 w3-light-grey col-sm-4" style="height:35em; top:3em;">
		
	    	<div class="container col-sm-12" >
	    		<!--Sign in Form start -->
				<form class="form-signin" action="/InsaneNerds/Signin_normal" method="post">
	        		<h2 class="form-signin-heading">Please sign in</h2>
	        		<label for="inputEmail" class="sr-only">Email address</label>
			        <input type="email" id="inputEmail" name="emailid" class="form-control input-lg" placeholder="Email address" required autofocus><br>
			        <label for="inputPassword" class="sr-only" >Password</label>
			        <input type="password" id="inputPassword" name="password" class="form-control input-lg" placeholder="Password" required><br>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button><br>
	     		</form>
				<!--Sign in Form end -->
	
				<!--Sign in with Social-sites start -->
				<form class="form-signin" action="/InsaneNerds/Login_Bridge" method="get">
					<button type="submit" name="Login" class="btn btn-block btn-social btn-google btn-danger btn-lg btn-block " value="Sign in with Google">
				            <span class="fa fa-google-plus"></span> Sign in with Google
				    </button><br>
				    <button type="submit" name="Login" class="btn btn-block btn-social btn-facebook btn-info btn-lg  " value="Sign in with Facebook">
				            <span class="fa fa-facebook"></span> Sign in with Facebook
				   	</button><br>
				    <button class="btn btn-lg btn-success btn-block" type="submit" name="Login" value="Sign up">Sign up</button><br>
				</form>
				<!--Sign in with Social-sites end -->
				
			</div> 
		</div>
		<!--Middle nav-bar end -->
		
	<!--right nav-bar start -->	
	<div class="col-sm-4 sidenav"></div>
	<!--right nav-bar end -->
	
	<%}else{ 
	//if name and confirm is not null go to timeline
				response.sendRedirect("http://localhost:8080/InsaneNerds/Timeline.jsp");
	
	} %>
	
	
	</body>
</html>
