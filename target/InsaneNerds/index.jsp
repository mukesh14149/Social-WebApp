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
<form action="/InsaneNerds/Login_Bridge" method="get">
    <input type="submit" name="Login" value="Go to Google">
    <input type="submit" name="Login" value="Go to Facebook">
</form>
<%}else{ %>
<h2>Hello <%=Name%></h2>
<%} %>


</body>
</html>
