//Upgrade no. of likes or degrade no. of likes in table depend on user click. 
package com.ebooks.timeline.likes;

import java.io.IOException;
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
 * Servlet implementation class likes_dislikes
 */
@WebServlet("/likes_dislikes")
public class likes_dislikes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likes_dislikes() {
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
		String like=request.getParameter("like");		//for like button.
		String unlike=request.getParameter("unlike");	//for unlike button.
		String emailid=(String) sess.getAttribute("emailid");
		
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        likes likes1=new likes(); //likes table
        if(like!=null){			//if like button press
        	Query q1 = session.createQuery("update timeline set likes=likes + 1 where id=:code"); //update value by 1
            q1.setParameter("code", Integer.parseInt(like));
            q1.executeUpdate();
            System.out.println("uyoyoyooyyoy");
            likes1.sethash(Integer.parseInt(like));	//save email and id of post who like this post.
            likes1.setEmailid(emailid);
            
        }
        else{	//if unlike is press
        	System.out.println("yyyyyyyyyyyyyyyy"+Integer.parseInt(unlike));
        	Query q1 = session.createQuery("update timeline set likes=likes - 1 where id=:code");	//degrade value of like
            q1.setParameter("code", Integer.parseInt(unlike));
            q1.executeUpdate();
            
            Query q2 = session.createQuery("Delete from likes where hash=:hash");	//delete his/her email id and hash from table
            q2.setParameter("hash", Integer.parseInt(unlike));
            q2.executeUpdate();
            
        }
        session.save(likes1);	//save table
        session.close();
        response.sendRedirect(request.getContextPath()+"/Timeline.jsp");
	}

}
