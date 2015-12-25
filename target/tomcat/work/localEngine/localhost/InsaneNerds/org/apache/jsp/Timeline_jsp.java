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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
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
		try{
			post=ob_time.post;
			hashid=ob_time.hashid;
			likes=ob_time.likes;
			hash=ob_likes.hash;
		}catch(Exception e){}
		
		
      out.write('\n');
      out.write('	');
if(emailid!=null){ 
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t<form method=\"post\" action=\"/InsaneNerds/Store_Timeline_Data\"  \n");
      out.write("        enctype=\"multipart/form-data\">  \n");
      out.write("        <table>  \n");
      out.write("            <tr>  \n");
      out.write("                <td>Post:</td>  \n");
      out.write("                <td><input type=\"text\" name=\"post\" size=\"50\"  \n");
      out.write("                    required=\"required\" /></td>  \n");
      out.write("            </tr>  \n");
      out.write("           \n");
      out.write("            <tr>  \n");
      out.write("                <td>Choose Image:</td>  \n");
      out.write("                <td><input type=\"file\" name=\"photo\" size=\"50\"  \n");
      out.write("                     /></td>  \n");
      out.write("            </tr>  \n");
      out.write("            <tr>  \n");
      out.write("                <td><input type=\"submit\" value=\"Submit\"></td>  \n");
      out.write("                <td><input type=\"reset\" value=\"Clear\" /></td>  \n");
      out.write("            </tr>  \n");
      out.write("        </table>  \n");
      out.write("    </form>  \n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t");
} 
      out.write('\n');
      out.write('	');
for(String name:post.keySet()){ String key =name.toString();
	
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(post.get(key));
		System.out.println(hashid.get(key));
		
		
      out.write(" \n");
      out.write("\t\t<h1>");
      out.print(key );
      out.write("</h1>\n");
      out.write("\t\t<img style=\"width:200px; height:200px;\" src=\"data:image/jpg;base64, ");
      out.print(b64);
      out.write("\" alt=\"******\" />\n");
      out.write("\t\t");
if(hash.contains(hashid.get(key))==false) {
      out.write("\n");
      out.write("\t\t<form action=\"/InsaneNerds/likes_dislikes\" method=\"post\"><button name=\"like\" value=");
      out.print(hashid.get(key));
      out.write(" type=\"submit\"  >Like</button></form>\n");
      out.write("\t\t");
} else{
      out.write("\n");
      out.write("\t\t<form action=\"/InsaneNerds/likes_dislikes\" method=\"post\"><button name=\"unlike\" value=");
      out.print(hashid.get(key));
      out.write(" type=\"submit\">Unlike</button></form>\n");
      out.write("\t");
 }
      out.write("\n");
      out.write("\t\t<h5>");
      out.print(likes.get(key) );
      out.write("</h5>\n");
      out.write("\t");
 } 
      out.write("\n");
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
