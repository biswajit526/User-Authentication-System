package in.biswa.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.biswa.dbConnection.JdbcConnection;
import in.biswa.entity.User;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email1");
		String password = request.getParameter("password1");
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		RequestDispatcher rd = null;
		
		try {
			connection = JdbcConnection.getDBConnection();
			String selectQuery = "select * from register where email=? and password=?";
			pstmt = connection.prepareStatement(selectQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setCity(resultSet.getString("city"));
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				rd = request.getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msg", "Invalid email and password");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcConnection.closeResource(resultSet, pstmt, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
