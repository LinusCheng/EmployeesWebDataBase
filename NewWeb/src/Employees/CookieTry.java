package Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieTry extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String Info_1          =  request.getParameter("Info_1");
		String Info_2          =  request.getParameter("Info_2");

		Cookie c1 =new Cookie("Info_1", Info_1);
		Cookie c2 =new Cookie("Info_2", Info_2);		
		c1.setMaxAge(30);
		c2.setMaxAge(10);
		response.addCookie(c1);
		response.addCookie(c2);		
		
		
		PrintWriter out  = response.getWriter();
		out.println("Cookie Updated" );
		
	    Cookie[] cookie_read = request.getCookies();
	    if (cookie_read != null) {
	    	out.println("Cookies:");
	        for (Cookie  cookie_i: cookie_read) {
	        	out.println(cookie_i.getName()+ " "+  cookie_i.getValue());
	            }
	        }
		
		
	}
	
	

	
}
