//For practise purpose.
package com.ebooks.login.Normal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ebooks.timeline.database.timeline;

public class check {
	
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		// TODO Auto-generated method stub
		
			Configuration cfg=new Configuration();  
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();  
	        Session session=factory.openSession();
	        Transaction t=session.beginTransaction();
	        
			HashSet<String> post=new HashSet<String>();
			
			Query q = session.createQuery("from Login");
			Iterator it=q.iterate();
			while(it.hasNext()){
				timeline time=(timeline) it.next();
				post.add(time.getPost());	
				System.out.println(time.getPost());
			}
			
			session.close();
			
		
        
	}

}
