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
	public  HashMap<String, byte[]> getPost() throws IOException{
		
		System.out.println("hello");
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        
		HashMap<String, byte[]> post=new HashMap<String, byte[]>();
		Query q = session.createQuery("from timeline");
		Iterator it=q.iterate();
		while(it.hasNext()){

	        timeline timeline=(timeline)it.next();
	        timeline.getEmailid();
	        BufferedImage img = ImageIO.read(new ByteArrayInputStream(timeline.getImage()));
	        post.put(timeline.getPost(), timeline.getImage());
	        System.out.println(img+"jelll");
		}
		
		
		session.close();
		return post;
		
	}
	
}
