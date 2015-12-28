//Logic:- Check in which way a user wants to logged in b/w fb, google.
//Or user wants to signup with us.

package com.ebooks.login.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Bridge
 */
@WebServlet("/Login_Bridge")
public class Login_Bridge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Bridge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//Sign in with google then send it to google auth service to authuntication for a user.
		if(request.getParameter("Login").toString().equals("Sign in with Google")){
			response.sendRedirect("https://accounts.google.com/o/oauth2/auth?scope=email%20profile&response_type=code&state=%2Fprofile&redirect_uri=http://localhost:8080/InsaneNerds/RegisterPage&client_id=253725670211-pkmtjrnt24d38jsj903i3kgapas93eqo.apps.googleusercontent.com");
		}
		
		//Sign in with Fb then send it to facebook auth service to authuntication for a user.
		if(request.getParameter("Login").toString().equals("Sign in with Facebook")){
			response.sendRedirect("https://facebook.com/dialog/oauth?client_id=758937600918147&scope=email,user_about_me,&redirect_uri=http://localhost:8080/InsaneNerds/FacebookPage");

		}
		
		//If user wants to Signup with us then send it to signup page.
		if(request.getParameter("Login").toString().equals("Sign up")){
			response.sendRedirect("http://localhost:8080/InsaneNerds/Site_login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}
