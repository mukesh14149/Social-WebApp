package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import org.apache.tomcat.jni.File;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\t    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t    \n");
      out.write("\t    \n");
      out.write("\t    <meta name=\"description\" content=\"\">\n");
      out.write("\t    <meta name=\"author\" content=\"\">\n");
      out.write("\t    <link rel=\"icon\" href=\"../../favicon.ico\">\n");
      out.write("\t\n");
      out.write("\t    \n");
      out.write("\t    <title>InsaneNerds</title>\n");
      out.write("\t\n");
      out.write("\t   \t<!-- bootstrap css and Js -->\n");
      out.write("\t   \t<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://www.w3schools.com/lib/w3.css\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<style>\n");
      out.write("\t\t\t.btn-danger {  background-color: #DD4B39;}\n");
      out.write("\t\t\t.btn-info {  background-color:  #3B5998;}\n");
      out.write("\t\t</style>\n");
      out.write("\t\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t\n");
      out.write("\t\t");

			HttpSession sess=request.getSession();
			String Name=(String) sess.getAttribute("Name");
			String confirm=(String) sess.getAttribute("confirm");
		    
		
      out.write('\n');
      out.write('	');
      out.write('	');
	//Check whether user is login or not by getting name value from session.
			if(Name==null || confirm!=null) { 
				if(Name==null){
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t");
	}
				//if name is not null check whether sign in user has confirm his/her mail or not.
				else {
      out.write("\n");
      out.write("\t\t<h2>Hello ");
      out.print(Name );
      out.write(" you need to confirm your mail and sign in again to get access</h2>\n");
      out.write("\t\t\t\t");
}sess.invalidate(); 
				//below form come in each case.
				
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<!--left nav-bar start -->\n");
      out.write("\t \t<div class=\"col-sm-4 sidenav\">\n");
      out.write("\t \t\t\t");
 if(Name==null){
      out.write("<h2>Hello World!</h2>");
} 
      out.write("\n");
      out.write("\t \t</div>\n");
      out.write("\t \t<!-- left nav-bar end -->\n");
      out.write("\t \t\n");
      out.write("\t \t\n");
      out.write("\t \t<!--Middle nav-bar start -->\n");
      out.write("\t\t<div class=\"w3-card-4 w3-light-grey col-sm-4\" style=\"height:35em; top:3em;\">\n");
      out.write("\t\t\n");
      out.write("\t    \t<div class=\"container col-sm-12\" >\n");
      out.write("\t    \t\t<!--Sign in Form start -->\n");
      out.write("\t\t\t\t<form class=\"form-signin\" action=\"/InsaneNerds/Signin_normal\" method=\"post\">\n");
      out.write("\t        \t\t<h2 class=\"form-signin-heading\">Please sign in</h2>\n");
      out.write("\t        \t\t<label for=\"inputEmail\" class=\"sr-only\">Email address</label>\n");
      out.write("\t\t\t        <input type=\"email\" id=\"inputEmail\" name=\"emailid\" class=\"form-control input-lg\" placeholder=\"Email address\" required autofocus><br>\n");
      out.write("\t\t\t        <label for=\"inputPassword\" class=\"sr-only\" >Password</label>\n");
      out.write("\t\t\t        <input type=\"password\" id=\"inputPassword\" name=\"password\" class=\"form-control input-lg\" placeholder=\"Password\" required><br>\n");
      out.write("\t\t\t        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button><br>\n");
      out.write("\t     \t\t</form>\n");
      out.write("\t\t\t\t<!--Sign in Form end -->\n");
      out.write("\t\n");
      out.write("\t\t\t\t<!--Sign in with Social-sites start -->\n");
      out.write("\t\t\t\t<form class=\"form-signin\" action=\"/InsaneNerds/Login_Bridge\" method=\"get\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\" name=\"Login\" class=\"btn btn-block btn-social btn-google btn-danger btn-lg btn-block \" value=\"Sign in with Google\">\n");
      out.write("\t\t\t\t            <span class=\"fa fa-google-plus\"></span> Sign in with Google\n");
      out.write("\t\t\t\t    </button><br>\n");
      out.write("\t\t\t\t    <button type=\"submit\" name=\"Login\" class=\"btn btn-block btn-social btn-facebook btn-info btn-lg  \" value=\"Sign in with Facebook\">\n");
      out.write("\t\t\t\t            <span class=\"fa fa-facebook\"></span> Sign in with Facebook\n");
      out.write("\t\t\t\t   \t</button><br>\n");
      out.write("\t\t\t\t    <button class=\"btn btn-lg btn-success btn-block\" type=\"submit\" name=\"Login\" value=\"Sign up\">Sign up</button><br>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t<!--Sign in with Social-sites end -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div> \n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--Middle nav-bar end -->\n");
      out.write("\t\t\n");
      out.write("\t<!--right nav-bar start -->\t\n");
      out.write("\t<div class=\"col-sm-4 sidenav\"></div>\n");
      out.write("\t<!--right nav-bar end -->\n");
      out.write("\t\n");
      out.write("\t");
}else{ 
	//if name and confirm is not null go to timeline
				response.sendRedirect("http://localhost:8080/InsaneNerds/Timeline.jsp");
	
	} 
      out.write("\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
