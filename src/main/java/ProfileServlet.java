
import java.io.IOException;
import java.sql.DriverManager;
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

import project.User;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_USER_BY_NAME = "select Name,Password,Date_Of_Birth,Email,Phone_Number,Address,Address2,City,State,Zip from customer where Name =?";
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private static final String DELETE_USERS_SQL = "delete from customer where Name = ?;";
	private static final String UPDATE_USERS_SQL = "update customer set Name = ?,Password= ?,Date_Of_Birth =?,Email =?,Phone_Number=?,Address,Address2,City,State,Zip where Name=?";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ProfileServlet/delete":
				deleteUser(request, response);
				break;
			case "/ProfileServlet/edit":
				showEditForm(request, response);
				break;
			case "/ProfileServlet/update":
				updateUser(request, response);
				break;
			case"/ProfileServlet/profile":
				userProfile(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private void userProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("12345");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("Username");
		System.out.println(user);
		User existingUser = new User("", "", "", "", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
			preparedStatement.setString(1, user);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				user = rs.getString("Name");
				String password = rs.getString("Password");
				String dateofbirth = rs.getString("Date_Of_Birth");
				String email = rs.getString("Email");
				String phone = rs.getString("Phone_Number");
				String address = rs.getString("Address");
				String address2 = rs.getString("Address2");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				existingUser = new User(user, password, dateofbirth, email, phone, address, address2, city, state, zip);
				System.out.println(existingUser.toString());
				System.out.println(dateofbirth);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		String email = request.getParameter("Email");
		String date = request.getParameter("Date_Of_Birth");
		String phone = request.getParameter("Phone_Number");
		String address = request.getParameter("Address");
		String address2 = request.getParameter("Address2");
		String city = request.getParameter("City");
		String state = request.getParameter("State");
		String zip = request.getParameter("Zip");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, date);
			statement.setString(4, email);
			statement.setString(5, phone);
			statement.setString(6, address);
			statement.setString(7, address2);
			statement.setString(8, city);
			statement.setString(9, state);
			statement.setString(10, zip);
			statement.setString(11, oriName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project

		response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String name = request.getParameter("Name");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to

		response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
	}

}
