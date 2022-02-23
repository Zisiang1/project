import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sddevops.project.User;

import project.Favourite;

import java.util.List;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class FavouriteServlet
 */
@WebServlet("/FavouriteServlet")
public class FavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String SELECT_FAVOURITES_BY_NAME = "select * from FAVOURITES;";
	private static final String DELETE_FAVOURITES_SQL = "delete from FAVOURITES where title = ?;";

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavouriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/FavouriteServlet/delete":
				deleteFavourites(request, response);
				break;
			case "/FavouriteServlet/dashboard":
				listFavourites(request, response);
				break;
			case "FavouriteServlet":
				doPost(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listFavourites(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Favourite> favourites = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FAVOURITES_BY_NAME);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String name = rs.getString("name");
				favourites.add(new Favourite(title, author, name));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listFavourites", favourites);
		request.getRequestDispatcher("/favouriteManagement.jsp").forward(request, response);
	}

	private void deleteFavourites(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String title = request.getParameter("title");
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FAVOURITES_SQL);) {
			statement.setString(1, title);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/GroupProject/FavouriteServlet/dashboard");
	}
}
