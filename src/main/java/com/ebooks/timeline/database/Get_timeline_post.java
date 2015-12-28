//Logic:- Get post from table to show them in timeline.
package com.ebooks.timeline.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ebooks.database.save.Login;

import javax.imageio.ImageIO;
import javax.servlet.*;

public class Get_timeline_post {
	public HashMap<String, byte[]> post=new HashMap<String, byte[]>();
	public HashMap<String,Integer> hashid=new HashMap<String,Integer>();
	public HashMap<String,Integer> likes=new HashMap<String,Integer>();

	
	
	public   Get_timeline_post() throws IOException{
		
		System.out.println("hello");
		
		//Setting session to get access to table.
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        
	
		Query q = session.createQuery("from timeline");
		Iterator it=q.iterate();
		while(it.hasNext()){

	        timeline timeline=(timeline)it.next();
	        timeline.getEmailid();
	        BufferedImage img = ImageIO.read(new ByteArrayInputStream(timeline.getImage()));
	        post.put(timeline.getPost(), timeline.getImage());		//set post and image in hashmap
	        hashid.put(timeline.getPost(),timeline.getId());		//set post and its id no. in hashmap
	        likes.put(timeline.getPost(),timeline.getLikes());		//set post and no. of likes in hashmap.
	        System.out.println(img+"jelll");
		}
		
		
		session.close();
		
		
	}
	
}
