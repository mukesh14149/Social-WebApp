package com.ebooks.login.Normal;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

import com.ebooks.database.save.Login;

/**
 * Servlet implementation class Normal_login
 */
@WebServlet("/Signin_normal")
public class Signin_normal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin_normal() {
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
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
          
        //creating seession factory object  
        SessionFactory factory=cfg.buildSessionFactory();  
          
        //creating session object  
        Session session=factory.openSession();  
          
        //creating transaction object  
        Transaction t=session.beginTransaction();  
     
        Query q = session.createQuery("from Login where emailid = :code ");
        q.setParameter("code", emailid);
        
        Iterator it=q.iterate();
        while(it.hasNext())
        {
        	Login e=(Login)it.next();
	        String database_pass =e.getPassword();
	        Integer database_active=e.getActive();
	        
	        if(password.equals(database_pass) && database_pass!=null &&database_active!=0){
	        	sess.setAttribute("emailid", e.getEmailid());
	    		sess.setAttribute("Name", e.getName());
	        	System.out.println("yuyoooo");
	    		response.sendRedirect(request.getContextPath() + "/index.jsp");
	    		return;
	        }
        }   
        session.close();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    
        return;

	}

}

