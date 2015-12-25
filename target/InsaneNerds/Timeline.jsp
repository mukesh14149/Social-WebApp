<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.io.*"
import="java.util.*"
import="com.ebooks.timeline.database.Get_timeline_post"
import="com.ebooks.timeline.likes.fetch_likes"
import="javax.servlet.*"
import="org.apache.tomcat.jni.File"
import="java.awt.image.BufferedImage"

%>
	<%	System.out.println("Request send");	
		HttpSession sess=request.getSession();
		String emailid=(String)sess.getAttribute("emailid");
		Get_timeline_post ob_time=new Get_timeline_post();
		fetch_likes ob_likes=new fetch_likes(emailid);
		HashMap<String, byte[]> post=null;
		HashMap<String,Integer> hashid=null;
		HashSet<Integer> hash=null;
		try{
			post=ob_time.post;
			hashid=ob_time.hashid;
			hash=ob_likes.hash;
		}catch(Exception e){}
		
		%>
	<%if(emailid!=null){ %>
		
	<form method="post" action="/InsaneNerds/Store_Timeline_Data"  
        enctype="multipart/form-data">  
        <table>  
            <tr>  
                <td>Post:</td>  
                <td><input type="text" name="post" size="50"  
                    required="required" /></td>  
            </tr>  
           
            <tr>  
                <td>Choose Image:</td>  
                <td><input type="file" name="photo" size="50"  
                     /></td>  
            </tr>  
            <tr>  
                <td><input type="submit" value="Submit"></td>  
                <td><input type="reset" value="Clear" /></td>  
            </tr>  
        </table>  
    </form>  
	
	
	<%} %>
	<%for(String name:post.keySet()){ String key =name.toString();
	
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(post.get(key));
		System.out.println(hashid.get(key));
		
		%> 
		<h1><%=key %></h1>
		<img style="width:200px; height:200px;" src="data:image/jpg;base64, <%=b64%>" alt="******" />
		<%if(hash.contains(hashid.get(key))==false) {%>
		<a><button name="like" value=<%=hashid.get(key)%>  >Like</button></a>
		<%} else{%>
		<a><button name="unlike" value=<%=hashid.get(key)%> >Unlike</button></a>
	<% }} %>
		
</body>
</html>