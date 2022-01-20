

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	
	 private static final String SELECT_ALL_USERS = "select * from customer where Name= ? and Password=? ";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123");
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String n = request.getParameter("username");
	        String p = request.getParameter("password");
	   
	    	
	        try (Connection connection = getConnection();
	        		
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	        	
	        	preparedStatement.setString(1, n);
	        	preparedStatement.setString(2, p);
	        	System.out.println(n);
	        	System.out.println(p);
	        	ResultSet rs = preparedStatement.executeQuery();
	        	System.out.println("Working");
	        	System.out.println(rs);
	        	if(rs.next())
	        	
	        	{        		
	        		String name = rs.getString("name");

	        		
	        		HttpSession session = request.getSession();
                    session.setAttribute("Username", name);
                    var user= session.getAttribute("Username");
                    System.out.println(user);

	        		

	        		response.sendRedirect("http://localhost:8090/GroupProject/ProductServlet");
	        		
	        	}
	        	
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	        
			
			
		doGet(request, response);
	}
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
