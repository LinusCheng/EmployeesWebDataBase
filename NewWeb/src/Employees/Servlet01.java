package Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
				
		PrintWriter out  = response.getWriter();
		out.println("Home Page ");
		
		
	}
	
}