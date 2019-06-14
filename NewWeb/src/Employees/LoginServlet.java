package Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;


public class LoginServlet extends HttpServlet{

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String usr        =request.getParameter("usr");
		String pw         =request.getParameter("pw");
		int   acc_type  =1;
		PrintWriter out=response.getWriter();
		
		boolean operate=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		

		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12341234");
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM test.LOGIN WHERE  user_name= ?");
			stmt.setString(1, usr);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			byte[] salt = {31, 9, -31, -20, -73, 112, -74, -6, 58, -126, 61, -105, 41, 10, -11, -126};
			PWHash H = new PWHash();
			
			if ( H.check_pw(salt, pw ,rs.getString(3))  ) {
				operate=true;
				acc_type = rs.getInt(4);
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(operate) {
			
//			HttpSession se=request.getSession(false);
			HttpSession se=request.getSession();

			se.setAttribute("usr", usr);
			se.setAttribute("acc_type", acc_type);

	        request.getRequestDispatcher("index.jsp").include(request, response);  
	        


		}else {
	        request.getRequestDispatcher("LoginPage.html").include(request, response);  
			 out.println(" ");  
			 out.println("Wrong Login Info");  
		}
		
	
		
}}
	

