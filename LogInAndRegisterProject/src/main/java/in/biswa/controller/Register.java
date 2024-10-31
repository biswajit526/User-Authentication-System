package in.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.biswa.dbConnection.JdbcConnection;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name1");
		String mail = request.getParameter("email1");
		String password = request.getParameter("password1");
		String city = request.getParameter("city1");
		Connection connection = null;
		PreparedStatement pstmt = null;
		RequestDispatcher rd = null;
		try {
			connection = JdbcConnection.getDBConnection();
			String InsertQuery = "insert into register(name, email, password, city) values(?, ?, ?, ?)";
			pstmt = connection.prepareStatement(InsertQuery);
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			pstmt.setString(3, password);
			pstmt.setString(4, city);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected > 0) {
				out.println("<h2 style ='color: green'>Registration Successful</h2>");
				
				rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msg", "Registration Successful");
				rd.forward(request, response);
			}else {
				out.println("<h2 style ='color: red'>Registration unsuccessful</h2>");
				
				rd = request.getRequestDispatcher("/register.jsp");
				request.setAttribute("msg", "Registration UnSuccessful");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcConnection.closeResource(null, pstmt, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
