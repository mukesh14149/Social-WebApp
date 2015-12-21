<html>
<body>

<%@ page import="java.io.*"
import="java.util.*"
import="javax.servlet.*"
import="org.apache.tomcat.jni.File"
%>
<%
	HttpSession sess=request.getSession();
	String Name=(String) sess.getAttribute("Name");
    
%>
<%if(Name==null){ %>
<h2>Hello World!</h2>
<form action="/InsaneNerds/Signin_normal" method="post">  
			Email:<input type="text" name="emailid"><br>  
		    Password:<input type="password" name="password"><br>  
		    <input type="submit" value="login">  
    	</form>

<form action="/InsaneNerds/Login_Bridge" method="get">
    <input type="submit" name="Login" value="Go to Google">
    <input type="submit" name="Login" value="Go to Facebook">
    <input type="submit" name="Login" value="Go to login">
</form>
<%}else{ %>
<h2>Hello <%=Name%></h2>
<a href="Logout.jsp">Logout</a>
<%} %>


</body>
</html>
