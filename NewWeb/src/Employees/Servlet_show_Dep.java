package Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_show_Dep extends HttpServlet{

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {

		PrintWriter out  = response.getWriter();
		
		out.append("<!DOCTYPE html>" );
		out.append("<html>" );
		out.append("<head>" );
		out.append("<title>Show_Dep</title>" );
		out.append("<link rel='stylesheet' type='text/css' href='/NewWeb/css/style.css' />" );
		out.append("</head>" );

		

		out.print("<h2>Dep List</h2><br>");

		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			out.println("forName NOT EXE");
		}
		

		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12341234");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT *  FROM test.DEP;");

			while(rs.next()) {
				
				out.println("Dep ID: " + rs.getInt(1)+"      Dep name: "+rs.getString(2)+"<br>");
				
			}
			
			



			
			stmt.close();
			con.close();


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("SQL NOT EXE");
		}
		
		out.append("<br><a href=\"/NewWeb/\">Home</a>");
		out.append("</html>" );
	
}}
