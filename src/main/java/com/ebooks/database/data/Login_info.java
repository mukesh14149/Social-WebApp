//Secure the amount for sign in facebook and google

package com.ebooks.database.data;

import java.io.IOException;
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
 * Servlet implementation class Login_info
 */
@WebServlet("/Login_info")

public class Login_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hsession=request.getSession();
		String Name=(String) hsession.getAttribute("Name");
		String emailid=(String) hsession.getAttribute("emailid");
		String password=(String) hsession.getAttribute("password");
		String hash=(String) hsession.getAttribute("hash");
		String expirydate=(String) hsession.getAttribute("expirydate");
		
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
          
        //creating seession factory object  
        SessionFactory factory=cfg.buildSessionFactory();  
          
        //creating session object  
        Session session=factory.openSession();  
          
        //creating transaction object  
        Transaction t=session.beginTransaction();  
          
        Login datavalue = new Login();  
        datavalue.setEmailid(emailid);  
        datavalue.setName(Name);  
        datavalue.setAmount(0);
        datavalue.setPassword(password);
        if(expirydate==null){
        	expirydate="24/12/15 9:52 PM";
        }
        datavalue.setExpirydate(expirydate);
        datavalue.setHash(hash);
        datavalue.setActive(0);
        
        
        
        session.save(datavalue);//persisting the object  
        t.commit();//transaction is committed  
        
          
        System.out.println("successfully saved");  

        session.close();
	
        if(hash!=null){
        	hsession.setAttribute("confirm", "No");
        }	
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
