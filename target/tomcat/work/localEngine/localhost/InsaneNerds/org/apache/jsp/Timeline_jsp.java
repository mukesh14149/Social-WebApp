package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import com.ebooks.timeline.database.Get_timeline_post;
import com.ebooks.timeline.likes.fetch_likes;
import javax.servlet.*;
import org.apache.tomcat.jni.File;
import java.awt.image.BufferedImage;

public final class Timeline_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\t");
	
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
		
		
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write(" <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"icon\" href=\"../../favicon.ico\">\n");
      out.write("\n");
      out.write("    <title>Signin Template for Bootstrap</title>\n");
      out.write("\n");
      out.write("   \t<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- jQuery library -->\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- Latest compiled JavaScript -->\n");
      out.write("\t<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("\t <link rel=\"stylesheet\" href=\"http://www.w3schools.com/lib/w3.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("\t<style>\n");
      out.write("\t\t.btn-danger {  background-color: #DD4B39;}\n");
      out.write("\t\t.btn-info {  background-color:  #3B5998;}\n");
      out.write("\t\t\n");
      out.write("\t</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\t\t<div class=\"w3-card-4 \" style=\"width:100%\">\n");
      out.write("\t\t\t    <nav class=\"navbar navbar-inverse \">\n");
      out.write("\t\t\t   \t <div class=\"container-fluid\">\n");
      out.write("\t\t\t   \t\t <div class=\"navbar-header \">\n");
      out.write("\t\t\t    \t\t\t<a class=\"navbar-brand\" href=\"#\">InsaneNerds</a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">About</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"https://github.com/InsaneNerds/InsaneNerds\">Contribute</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"http://www.mukeshgupta.me/\">Contact us</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t");
 if(Name==null){
      out.write("\n");
      out.write("\t\t\t\t<li><a href=\"http://localhost:8080/InsaneNerds/Site_login.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"http://localhost:8080/InsaneNerds/index.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("\t\t\t     \n");
      out.write("\t\t\t     ");
}else{ 
      out.write("\n");
      out.write("\t\t\t     \n");
      out.write("\t\t\t     \t\t<li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span>");
      out.print(Name);
      out.write("</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"http://localhost:8080/InsaneNerds/Logout.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>\n");
      out.write("\t\t\t     ");
} 
      out.write(" \n");
      out.write("\t\t\t      </ul>\n");
      out.write("\t\t\t    \n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t");
if(emailid!=null){ 
      out.write("\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t  \t\t\t<div class=\"col-sm-4\"></div>\n");
      out.write("\t\t  \t\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t\t\t\t<form  class=\"form-signin\" method=\"post\" action=\"/InsaneNerds/Store_Timeline_Data\"  \n");
      out.write("\t\t\t\t\t        enctype=\"multipart/form-data\">  \n");
      out.write("        \n");
      out.write("\t\t\t                <input type=\"text\" class=\"form-control w3-card-32\" id=\"usr\" name=\"post\" required=\"required\"> \n");
      out.write("\t\t\t                 <div class=\"col-sm-9\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"file\" name=\"photo\" class=\"btn btn-sm  btn-block\"/>\n");
      out.write("\t\t\t\t\t\t\t</div> \n");
      out.write("\t\t\t          \t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-block btn-primary w3-card-4\">Post</button>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("    \t\t\t\t\t</form>  \n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-4\"></div>\n");
      out.write("\t\t</div>\t\t\n");
      out.write("\t\t<br><br>\n");
      out.write("\t\n");
      out.write("\t");
} 
      out.write('\n');
      out.write('	');
for(String name:post.keySet()){ String key =name.toString();
	
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(post.get(key));
		System.out.println(hashid.get(key));
		String originalString1 = key;
		String newString1 = originalString1.replaceAll("http://.+?(com|me|org)/{0,1}", "<a href=\"$0\">$0</a>");
		
      out.write(" \n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t  <div class=\"col-sm-3\"></div>\n");
      out.write("\t\t\t  <div class=\"col-sm-6\">\n");
      out.write("\t\t\t\t<div class=\"w3-card-4\" >\n");
      out.write("\t\t\t  \t\t<div class=\"w3-container w3-card-4 col-sm-12\">\n");
      out.write("\t\t\t  \t\t\t\t<p>");
      out.print(newString1 );
      out.write("</p>\n");
      out.write("\t\t\t  \t\t\t\t<img class=\"img-thumbnail img-responsive col-sm-12\"  src=\"data:image/jpg;base64, ");
      out.print(b64);
      out.write("\" alt=\"\"/>\n");
      out.write("\t\t\t  \t\t\t\t<div class=\"img-thumbnail img-responsive col-sm-12 form-inline\">\n");
      out.write("\t\t\t  \t\t\t\t\t<div class=\"col-sm-6\"><form action=\"/InsaneNerds/likes_dislikes\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
if(emailid!=null) {if(hash.contains(hashid.get(key))==false) {
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button name=\"like\" class=\"btn btn-sm btn-primary \" value=");
      out.print(hashid.get(key));
      out.write(" type=\"submit\"  >Like<span class=\"badge\">");
      out.print(likes.get(key) );
      out.write("</span></button>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
} else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button name=\"unlike\" class=\"btn btn-sm btn-primary \" value=");
      out.print(hashid.get(key));
      out.write(" type=\"submit\">Unlike<span class=\"badge\">");
      out.print(likes.get(key) );
      out.write("</span></button>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 }}
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</form></div>\n");
      out.write("\t\t\t\t\t\t\t  <div class=\"col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t  \t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<div  class=\" w3-container w3-card-4 col-sm-12\">\n");
      out.write("\t\t\t\t\t\t\t <ul class=\"list-group\">\n");
      out.write("\t\t\t\t\t\t\t <li class=\"list-group-item\">\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t<form action=\"/InsaneNerds/comment_set\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t<button class=\"btn btn-sm btn-primary\"  name=\"commentid\" value=");
      out.print(hashid.get(key));
      out.write(" type=\"submit\">Comment</button>\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t");
if(emailid!=null){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control w3-card-32\" name=\"comment\" id=\"usr\" /> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("               \t\t\t\t\t\t\t\t");
} 
      out.write(" \n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t  </li>\n");
      out.write("\t\t\t\t\t\t\t \t\t");
try{if(comments.containsValue(hashid.get(key))){ 
													System.out.println("yes i am in");
											
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
 		for(String comm:comments.keySet()){ 
													if(hashid.get(key).equals(comments.get(comm))){					
													String originalString = comm;
													String newString = originalString.replaceAll("http://.+?(com|me|org)/{0,1}", "<a href=\"$0\">$0</a>");
												
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t<li class=\"list-group-item\">");
      out.print(newString);
      out.write("</li>\n");
      out.write("\t\t\t\t\t\t\t \t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}} 
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
 }}catch(Exception e){					} 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t  \t\t</div>\n");
      out.write("\t\t\t  \t</div>\n");
      out.write("\t\t\t  </div>\n");
      out.write("\t\t\t  <div class=\"col-sm-3\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\t<br><br><br> \t\t\n");
      out.write("\t");
 }
      out.write("\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
