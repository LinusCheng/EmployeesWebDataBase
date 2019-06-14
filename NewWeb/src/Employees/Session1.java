package Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session1 extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession se=request.getSession(false);
		se.setAttribute("val1", "val2");
		PrintWriter out=response.getWriter();	
		out.println(se.getId());

		
}}
