package Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Show_Session extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		HttpSession se = request.getSession(false);
//		if (false) won't create session if no session
//     can show some memory
		
		
		out.append("<!DOCTYPE html>" );
		out.append("<html>" );
		out.append("<head>" );
		out.append("<title>Profile</title>" );
		out.append("<link rel='stylesheet' type='text/css' href='/NewWeb/css/style.css' />" );
		out.append("</head>" );
		
		

		if (se != null) {
			String usr = (String) se.getAttribute("usr");
			out.println("In the Session: "+usr+"<br>");
						
			int  acc_type = (Integer) se.getAttribute("acc_type");

			if (acc_type==0) {
				out.print("Account type: Admin<br>");
			}else {
				out.print("Account type: Normal user<br>");
			}
			
			
			
			
		} else {
			out.print("Please Log in");
		}
		
		out.append("<br><a href=\"/NewWeb/\">Home</a>");
		out.append("</html>" );
	
}}
