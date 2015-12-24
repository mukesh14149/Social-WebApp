package com.ebooks.login.Normal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class confirmation_mail_send
 */
@WebServlet("/confirmation_mail_send")
public class confirmation_mail_send extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat format=new SimpleDateFormat();

    private static final int EXPIRATION = 60 * 24;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmation_mail_send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

        HttpSession session=request.getSession();
        String emailid=(String) session.getAttribute("emailid");
		String hash = UUID.randomUUID().toString();
		String expirydate=calculateExpirydate(EXPIRATION);
		session.setAttribute("hash", hash);
		session.setAttribute("expirydate", expirydate);
		try{
			send_Email(emailid,hash);
		}catch(Exception e){
			
		}
		response.sendRedirect(request.getContextPath() + "/Login_info");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
	}
	public String calculateExpirydate(int expiryTimeInMinutes){
		DateFormat format=new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        
        return format.format(cal.getTime());
	}
	public void send_Email(String emailid,String hash){
		 
	      
		 String mailBody = "Confirm your mail by <a href=\"http://localhost:8080/InsaneNerds/confirm_mail_save?emailid="+emailid+"&token="+hash+"\">click here</a>";
		 Mailer.send(emailid,"InsaneNerds",mailBody);  
		 System.out.println("your mail is send");
	}
}
