//Logic:- Request to google and ask permission for a user then sign in with google, set session for email id and name and send it to login_info for save the info.
package com.ebooks.login.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebooks.login.Google.GooglePojo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	 //client id and client Secret
	 private static final String CLIENT_ID = "253725670211-pkmtjrnt24d38jsj903i3kgapas93eqo.apps.googleusercontent.com";
	 private static final String CLIENT_SECRET = "aAMY2xPQ2nGrJgDSq27VBH8M"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		//Create session.
		HttpSession session=request.getSession();				
		try 
		{
			//Google auth redirect url gives one code, use this code to get accesscode and then fetch user data.
			
			String code = request.getParameter("code");
			String urlParameters = "code=" + code
					+ "&client_id=" + CLIENT_ID
					+ "&client_secret="+ CLIENT_SECRET
					+ "&redirect_uri=http://localhost:8080/InsaneNerds/RegisterPage"
					+ "&grant_type=authorization_code";

			// post parameters
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			// get output in outputString
			String line, outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// get Access Token
			JsonObject json = (JsonObject) new JsonParser().parse(outputString);
			String access_token = json.get("access_token").getAsString();

			// get User Info
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + access_token);
			urlConn = url.openConnection();
			outputString = "";
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// Convert JSON response into Pojo class
			GooglePojo data = new Gson().fromJson(outputString, GooglePojo.class);
			System.out.println(data.getEmail());
			System.out.println(data.getName());
			
			//save emailid and name in a session.
			session.setAttribute("emailid", data.getEmail());
			session.setAttribute("Name", data.getName());
			writer.close();
			reader.close();

		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e);
		}
		catch (ProtocolException e) 
		{
			System.out.println(e);
		} catch (IOException e) 
		{
			System.out.println(e);
		}
		
		//Send to login_info to save resource.
		response.sendRedirect(request.getContextPath() + "/Login_info");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
