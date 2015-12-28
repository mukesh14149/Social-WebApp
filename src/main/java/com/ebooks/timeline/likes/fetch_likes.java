//Logic:- Get the likes on every post on a timeline of a logged in user and show at timeline that whether user liked that particular post or not.
//create hashset of ids no.  post which contain logged in user likes. 
package com.ebooks.timeline.likes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ebooks.timeline.database.timeline;

public class fetch_likes {
	public HashSet<Integer> hash=new HashSet<Integer>();
	public fetch_likes(String emailid){
		
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        Query q = session.createQuery("from likes where emailid = :code ");
        q.setParameter("code", emailid);	//Get data of logged in user by his/her mail.
        
		Iterator it=q.iterate();
		while(it.hasNext()){

	        likes likes=(likes)it.next();
	    
	        hash.add(likes.gethash());	//Add id of post which is liked by logged in user.
	        
		}
        session.close();

	}
}
