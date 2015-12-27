package com.ebooks.timeline.comment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class comment_get
 */
@WebServlet("/comment_get")
public class comment_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment_get() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		String hash=(String) sess.getAttribute("hash");
		System.out.println("yooooooooooooooooooo");
		System.out.println("yo"+hash);

		HashMap<String,Integer> comments=new HashMap<String,Integer>();
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        Query q = session.createQuery("from comment where hash = :code ");
        q.setParameter("code", Integer.parseInt(hash));
        Iterator it=q.iterate();
        while(it.hasNext()){
        	System.out.println("howmanytime");
        	comment comm=(comment) it.next();
        	comments.put(comm.getComment(),comm.gethash());
        	System.out.println("chlo1"+comments.get(comm.gethash())+comments.size());
        	 
        }
        session.close();
       
        sess.setAttribute("comments", comments);
        response.sendRedirect(request.getContextPath()+"/Timeline.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
	}

}
