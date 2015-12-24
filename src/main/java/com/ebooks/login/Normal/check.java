package com.ebooks.login.Normal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class check {
	
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm a");
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 60*24);
        
        Date date=format.parse("24/12/15 8:06 PM");
        Date date1 = new Date();
        System.out.println(format.format(date));
        System.out.println(format.format(date1));
      
        System.out.println(format.format(date).compareTo(format.format(date1)));
        
	}

}
