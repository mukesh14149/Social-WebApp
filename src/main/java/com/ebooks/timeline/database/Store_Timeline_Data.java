package com.ebooks.timeline.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Object;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class Store_Timeline_Data
 */

@WebServlet("/Store_Timeline_Data")
@MultipartConfig(maxFileSize = 16177215) 
public class Store_Timeline_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_Timeline_Data() {
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
		Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        HttpSession sess=request.getSession();
        String emailid=(String)sess.getAttribute("emailid");
        InputStream inputStream = null;
        String name;
        String value=null;
        FileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart)
        {
            try 
            {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) 
                {
                    FileItem item = (FileItem) iterator.next();

                    if (item.isFormField()) //your code for getting form fields
                    {
                        name = item.getFieldName();
                        value = item.getString();
                        
                    }

                    if (!item.isFormField()) 
                    {
                       //your code for getting multipart 
                    	
                    	
                    	 inputStream = item.getInputStream();
                    	 System.out.println("sadf"+inputStream);
                    	 
                    }
                }
            }catch(Exception e){System.out.println("sadfchal j");e.printStackTrace();}
        }     
        
       
        
        
        System.out.println(emailid+" "+value+"yoy");
    	
        byte[] bytes = IOUtils.toByteArray(inputStream);
       
        
        
        timeline timeline=new timeline();
        timeline.setEmailid(emailid);
        timeline.setPost(value);
        if(inputStream!=null){
        timeline.setImage(bytes);
        }
        
        session.save(timeline);
        session.close();
		
        
        response.sendRedirect(request.getContextPath()+"/Timeline.jsp");
	}

}
