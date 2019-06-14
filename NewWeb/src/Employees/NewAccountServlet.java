package Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

public class NewAccountServlet extends HttpServlet {
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	String usr        =request.getParameter("usr");
	String pw         =request.getParameter("pw");
	int   acc_type  = Integer.parseInt( request.getParameter("acc_type"));
	int max_pk = 0;
	boolean operate =true;
	PrintWriter out=response.getWriter();


	try {
		Class.forName("com.mysql.jdbc.Driver");

	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	
	try {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12341234");
		
		try {
		PreparedStatement stmt0 = (PreparedStatement) con.prepareStatement("SELECT * FROM test.LOGIN WHERE  user_name= ?");
		stmt0.setString(1, usr);
		ResultSet rs = stmt0.executeQuery();
		
		
		
		if (rs.next()) {
		        request.getRequestDispatcher("NewAccount.html").include(request, response);  
				out.println("Duplicate user name. Please choose another one");
				operate=false;
			}else {
				operate=true;
//				out.println("Good user name");
		}
		
		
//		out.print("EXE OK");
		stmt0.close();
		}catch(SQLException e0){
			e0.printStackTrace();
//			out.println("NO SQL");
		}
		

		

		if(operate) {
		Statement stmt=(Statement) con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT MAX(U_ID) FROM test.LOGIN;");
		rs.next();
		max_pk =rs.getInt(1)+1;
		stmt.close();
		
		java.sql.PreparedStatement pstmt=con.prepareStatement("INSERT INTO test.LOGIN VALUE(?,?,?,?);");
		pstmt.setInt(1, max_pk);
		pstmt.setString(2, usr);
		pstmt.setString(3, pw);
		pstmt.setInt(4, acc_type);
		pstmt.execute();
		pstmt.close();

        request.getRequestDispatcher("index.jsp").include(request, response);  
        out.println("New user added");
		}

		
		con.close();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
	
	
	
	
	}

}
