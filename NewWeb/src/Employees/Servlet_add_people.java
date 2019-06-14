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

public class Servlet_add_people extends HttpServlet{

	
		
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {

		String Input_name       =  request.getParameter("Emp_name");
		String Input_pos          =  request.getParameter("Postion_name");
		int Input_salary            = Integer.parseInt(request.getParameter("Salary"));
		int Input_dep               = Integer.parseInt(request.getParameter("Dep_ID"));
		
		
		int max_pk = 0;

			try {
				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				PrintWriter out  = response.getWriter();
				out.println("forName NOT EXE");
			}
			
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12341234");
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT MAX(Emp_ID) FROM test.EMP;");
				rs.next();
				max_pk =rs.getInt(1)+1;
				
				java.sql.PreparedStatement pstmt=con.prepareStatement("INSERT INTO test.EMP VALUE(?,?,?,?,?);");
				pstmt.setInt(1, max_pk);
				pstmt.setString(2, Input_name);
				pstmt.setString(3, Input_pos);
				pstmt.setInt(4, Input_salary);
				pstmt.setInt(5, Input_dep);


				pstmt.execute();
				

				stmt.close();
				pstmt.close();
				con.close();


				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				PrintWriter out  = response.getWriter();
				out.println("SQL NOT EXE");
			}			
			

			PrintWriter out  = response.getWriter();
			out.println("New People ID: "+max_pk +" Name: "+Input_name+ " has added " );
			
	
	
//					how to set the homepage just  localhost/   not localhost/batch14/
	
}}
