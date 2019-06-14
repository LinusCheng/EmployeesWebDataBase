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

public class Servlet_show_Emp extends HttpServlet{

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {

		PrintWriter out  = response.getWriter();
		
		out.append("<!DOCTYPE html>" );
		out.append("<html>" );
		out.append("<head>" );
		out.append("<title>Show_Emp</title>" );
		out.append("<link rel='stylesheet' type='text/css' href='/NewWeb/css/style.css' />" );
		out.append("</head>" );

		

		out.print("<h2>Employees List</h2><br>");
//		out.println("\n");

		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			out.println("forName NOT EXE");
		}
		
		
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12341234");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM test.EMP e  LEFT JOIN test.DEP d ON d.Dep_ID = e.Dep_ID;");

			out.append("<table style=\"width:80%\">" );

			out.print("<tr><th>Emp ID</th><th>Name</th><th>Position</th>");
			out.print("<th>Salary</th><th>Dep</th><th></th></tr>");
			
			while(rs.next()) {
				out.append("<tr>");
				out.print("<th>" + rs.getInt(1)+"</th><th>"+rs.getString(2)+ "</th><th>"+rs.getString(3));
				out.print("</th><th>"+rs.getInt(4)+"</th><th>"+rs.getInt(5)+".</th><th>"+rs.getString(7)+"</th>");
				out.append("</tr>");
			}
			out.append("</table>");
			

			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("SQL NOT EXE");
		}
		out.append("<br><a href=\"/NewWeb/\">Home</a>");
		out.append("</html>" );
		
		
}}
