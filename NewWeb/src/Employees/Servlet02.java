package Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends HttpServlet{

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Dep_name = request.getParameter("dep_name");
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
				ResultSet rs=stmt.executeQuery("SELECT MAX(Dep_ID) FROM test.DEP;");
				rs.next();
				max_pk =rs.getInt(1)+1;
				
				
				
				java.sql.PreparedStatement pstmt=con.prepareStatement("INSERT INTO test.DEP VALUE(?,?);");
				pstmt.setInt(1, max_pk);
				pstmt.setString(2, Dep_name);
				pstmt.execute();
				
				
				
				
				stmt.close();
				con.close();


				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				PrintWriter out  = response.getWriter();
				out.println("SQL NOT EXE");
			}
			
			
			

			PrintWriter out  = response.getWriter();
			out.println("New department: "+Dep_name+ " " +max_pk);



		

		
		
	}
	
}