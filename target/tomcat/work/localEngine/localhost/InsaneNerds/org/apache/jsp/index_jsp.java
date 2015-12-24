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
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");

	HttpSession sess=request.getSession();
	String Name=(String) sess.getAttribute("Name");
	String confirm=(String) sess.getAttribute("confirm");
    

      out.write('\n');
if(Name==null || confirm!=null) { if(Name==null){
      out.write("\n");
      out.write("<h2>Hello World!</h2>\n");
}else {
      out.write("\n");
      out.write("<h2>Hello ");
      out.print(Name );
      out.write(" you need to confirm your mail and sign in again to get access</h2>\n");
}sess.invalidate(); 
      out.write("\n");
      out.write("<form action=\"/InsaneNerds/Signin_normal\" method=\"post\">  \n");
      out.write("\t\t\tEmail:<input type=\"text\" name=\"emailid\"><br>  \n");
      out.write("\t\t    Password:<input type=\"password\" name=\"password\"><br>  \n");
      out.write("\t\t    <input type=\"submit\" value=\"login\">  \n");
      out.write("    \t</form>\n");
      out.write("\n");
      out.write("<form action=\"/InsaneNerds/Login_Bridge\" method=\"get\">\n");
      out.write("    <input type=\"submit\" name=\"Login\" value=\"Go to Google\">\n");
      out.write("    <input type=\"submit\" name=\"Login\" value=\"Go to Facebook\">\n");
      out.write("    <input type=\"submit\" name=\"Login\" value=\"Go to login\">\n");
      out.write("</form>\n");
}else{ 
      out.write("\n");
      out.write("<h2>Hello ");
      out.print(Name);
      out.write("</h2>\n");
      out.write("<a href=\"Logout.jsp\">Logout</a>\n");
} 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
