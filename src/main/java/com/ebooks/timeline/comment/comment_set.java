package com.ebooks.timeline.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class comment_set
 */
@WebServlet("/comment_set")
public class comment_set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment_set() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		String emailid=(String) sess.getAttribute("emailid");
		String hash=request.getParameter("commentid");
		String comment=request.getParameter("comment");
		sess.setAttribute("hash", hash);
		if(emailid!=null){
		if(comment.isEmpty()==false){
			System.out.println("main commetn"+comment);
			Configuration cfg=new Configuration();  
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();  
	        Session session=factory.openSession();
	        Transaction t=session.beginTransaction();
	        comment com=new comment();
	        com.setComment(comment);
	        com.setEmailid(emailid);
	        com.sethash(Integer.parseInt(hash));
	        session.save(com);
	        session.close();
		}  
		}
		sess.removeAttribute("comment");
        response.sendRedirect(request.getContextPath()+"/comment_get");
        
      
	
	
	}

}
