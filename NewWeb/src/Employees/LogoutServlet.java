package Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



		
        HttpSession se=request.getSession();  
        se.invalidate();  
        
        
		PrintWriter out=response.getWriter(); 
        request.getRequestDispatcher("index.jsp").include(request, response);  
        out.print("\n\nLogged out!");  
        

        
          
        out.close();  
	
}}
