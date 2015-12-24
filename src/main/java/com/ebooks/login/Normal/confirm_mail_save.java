package com.ebooks.login.Normal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.ebooks.database.save.Login;

/**
 * Servlet implementation class confirm_mail_save
 */
@WebServlet("/confirm_mail_save")
public class confirm_mail_save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirm_mail_save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		String emailid=request.getParameter("emailid");
		String hash=request.getParameter("token");
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
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm a");
        	Login e=(Login)it.next();
	        String database_hash =e.getHash();
	        String database_date=e.getExpairydate();
	        Date date = null;
	        try {
				date=format.parse(database_date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Date date1 = new Date();
	        System.out.println(format.format(date));
	        System.out.println(format.format(date1));
	      
	        System.out.println(format.format(date).compareTo(format.format(date1)));
	        
	        int Expiry=format.format(date).compareTo(format.format(date1));
	        if(hash.equals(database_hash) && database_hash!=null && Expiry>=0){
	        	Query q1 = session.createQuery("update Login set active=1 where emailid=:code");
	            q1.setParameter("code", e.getEmailid());
	            int result = q1.executeUpdate();
	        	sess.setAttribute("emailid", e.getEmailid());
	    		sess.setAttribute("Name", e.getName());
	    
	        	System.out.println(e.getActive()+"yuyoooo"+e.getEmailid()+result);
	        	
	    		response.sendRedirect(request.getContextPath() + "/index.jsp");
	        }
        }   
        //response.sendRedirect(request.getContextPath() + "/index.jsp");
        session.close();
        PrintWriter out=response.getWriter();
        out.println("Soory This URL is Expire");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
