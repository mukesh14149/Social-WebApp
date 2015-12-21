package com.ebooks.login.Facebook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

/**
 * Servlet implementation class FacebookPage
 */
@WebServlet("/FacebookPage")
public class FacebookPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String APP_ID = "758937600918147";
	public static String APP_SECRET = "127770845824b36aad9f23c3f1139670"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacebookPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String code=request.getParameter("code");
		String URLEncodedRedirectURI = URLEncoder.encode("http://localhost:8080/InsaneNerds/FacebookPage");
		String authURL = "https://graph.facebook.com/oauth/access_token?" +
                "client_id=" + FacebookPage.APP_ID + "&" +
                "redirect_uri=" + URLEncodedRedirectURI + "&" +
                "client_secret=" + FacebookPage.APP_SECRET + "&" +
                "code=" + code;
		URL url = new URL(authURL);
		String access_token=null;
		String result = Extract_access_token(url);
		String[] pairs = result.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			if (kv[0].equals("access_token")) {
				access_token = kv[1];
			}
		}
		final FacebookClient facebookClient = new DefaultFacebookClient(access_token);
		User loginUser = facebookClient.fetchObject("me", User.class,Parameter.with("fields","email,name"));
		System.out.println(loginUser.getEmail());
		System.out.println(loginUser.getName());
		session.setAttribute("emailid", loginUser.getEmail());
		session.setAttribute("Name", loginUser.getName());
		response.sendRedirect(request.getContextPath() + "/Login_info");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private String Extract_access_token(URL url) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int r;
		while ((r = is.read()) != -1) {
			baos.write(r);
		}
		return new String(baos.toByteArray());
	}
	
}
