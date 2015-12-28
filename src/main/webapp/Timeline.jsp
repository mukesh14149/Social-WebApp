<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.*"
import="java.util.*"
import="com.ebooks.timeline.database.Get_timeline_post"
import="com.ebooks.timeline.likes.fetch_likes"
import="javax.servlet.*"
import="org.apache.tomcat.jni.File"
import="java.awt.image.BufferedImage"

%>   

	<%	
		System.out.println("Request send");	
		HttpSession sess=request.getSession();
		String emailid=(String)sess.getAttribute("emailid");
		Get_timeline_post ob_time=new Get_timeline_post();
		fetch_likes ob_likes=new fetch_likes(emailid);
		HashMap<String, byte[]> post=null;
		HashMap<String,Integer> hashid=null;
		HashSet<Integer> hash=null;
		HashMap<String,Integer> likes=null;
		String Name=(String) sess.getAttribute("Name");
		HashMap<String,Integer> comments=(HashMap<String,Integer>) sess.getAttribute("comments");
		try{
			post=ob_time.post;
			hashid=ob_time.hashid;
			likes=ob_time.likes;
			hash=ob_likes.hash;
		}catch(Exception e){}
		
		%>
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
			<div class="w3-card-4 " style="width:100%">
			    <nav class="navbar navbar-inverse ">
			   	 <div class="container-fluid">
			   		 <div class="navbar-header ">
			    			<a class="navbar-brand" href="#">InsaneNerds</a>
					</div>
				<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="https://github.com/InsaneNerds/InsaneNerds">Contribute</a></li>
					<li><a href="http://www.mukeshgupta.me/">Contact us</a></li>
				</ul>
			      <ul class="nav navbar-nav navbar-right">
				
				
				<% if(Name==null){%>
				<li><a href="http://localhost:8080/InsaneNerds/Site_login.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="http://localhost:8080/InsaneNerds/index.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			     
			     <%}else{ %>
			     
			     		<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=Name%></a></li>
						<li><a href="http://localhost:8080/InsaneNerds/Logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			     <%} %> 
			      </ul>
			    
			</nav>
		</div>





	<%if(emailid!=null){ %>
		<div class="container-fluid">
		  			<div class="col-sm-4"></div>
		  			<div class="col-sm-4">
						<form  class="form-signin" method="post" action="/InsaneNerds/Store_Timeline_Data"  
					        enctype="multipart/form-data">  
        
			                <input type="text" class="form-control w3-card-32" id="usr" name="post" required="required"> 
			                 <div class="col-sm-9">
										<input type="file" name="photo" class="btn btn-sm  btn-block"/>
							</div> 
			          		<div class="col-sm-3">
										<button type="submit" class="btn btn-block btn-primary w3-card-4">Post</button>
							</div>
    					</form>  
					</div>
					<div class="col-sm-4"></div>
		</div>		
		<br><br>
	
	<%} %>
	<%for(String name:post.keySet()){ String key =name.toString();
	
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(post.get(key));
		System.out.println(hashid.get(key));
		String originalString1 = key;
		String newString1 = originalString1.replaceAll("http://.+?(com|me|org)/{0,1}", "<a href=\"$0\">$0</a>");
		%> 
		
		<div class="container-fluid">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-6">
				<div class="w3-card-4" >
			  		<div class="w3-container w3-card-4 col-sm-12">
			  				<p><%=newString1 %></p>
			  				<img class="img-thumbnail img-responsive col-sm-12"  src="data:image/jpg;base64, <%=b64%>" alt=""/>
			  				<div class="img-thumbnail img-responsive col-sm-12 form-inline">
			  					<div class="col-sm-6"><form action="/InsaneNerds/likes_dislikes" method="post">
										<%if(emailid!=null) {if(hash.contains(hashid.get(key))==false) {%>
										
												<button name="like" class="btn btn-sm btn-primary " value=<%=hashid.get(key)%> type="submit"  >Like<span class="badge"><%=likes.get(key) %></span></button>
										<%} else{%>
												<button name="unlike" class="btn btn-sm btn-primary " value=<%=hashid.get(key)%> type="submit">Unlike<span class="badge"><%=likes.get(key) %></span></button>
									<% }}%>
								</form></div>
							  <div class="col-sm-6">
							  	</div>
							</div>
							
							<div  class=" w3-container w3-card-4 col-sm-12">
							 <ul class="list-group">
							 <li class="list-group-item">
							  				<form action="/InsaneNerds/comment_set" method="post">
							  				 
							  								<button class="btn btn-sm btn-primary"  name="commentid" value=<%=hashid.get(key)%> type="submit">Comment</button>
							  								<%if(emailid!=null){ %>
							  										<input type="text" class="form-control w3-card-32" name="comment" id="usr" /> 
															
               								<%} %> 
							  				</form>
							  
							  </li>
							 		<%try{if(comments.containsValue(hashid.get(key))){ 
													System.out.println("yes i am in");
											%>	
											
											
												
											<% 		for(String comm:comments.keySet()){ 
													if(hashid.get(key).equals(comments.get(comm))){					
													String originalString = comm;
													String newString = originalString.replaceAll("http://.+?(com|me|org)/{0,1}", "<a href=\"$0\">$0</a>");
												%>
										
							  			<li class="list-group-item"><%=newString%></li>
							 			
															<%}} %>	
												<% }}catch(Exception e){					} %>
							</ul>
						</div>
							
											
							  				
											
															
							  
							  
			  		</div>
			  	</div>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
			<br><br><br> 		
	<% }%>	
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
</body>
</html>