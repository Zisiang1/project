

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_ALL_CART_BY_USERNAME_AND_PAID = "select * from cart where username = ? and paid=1";
	private static final String DELETE_CART = "delete from cart where id=?";
	List<Cart> carts = new ArrayList<>();
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/BookingServlet/book":
				listBooking(request, response);
				break;
//			case "/CartServlet/pay":
//				updateBooking(request, response);
//				break;
//
			case "/BookingServlet/delete":
				deleteBooking(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		var user = (String) session.getAttribute("Username");
		
		carts.clear();

		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_ALL_CART_BY_USERNAME_AND_PAID);) {
			preparedStatement.setString(1, user);
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			System.out.println("abc");
			while (rs.next()) {
				int id = rs.getInt("id");
				int bookid = rs.getInt("bookid");
				String username = rs.getString("username");
				String book = rs.getString("book");
				String img = rs.getString("img");
				String paid = rs.getString("paid");
				String price = rs.getString("price");
				String quantity = rs.getString("quantity");
				String totalcost = rs.getString("totalcost");
				String date = rs.getString("date");

				// Cart c = new Cart(id, bookid, username, book, img, paid, price, quantity,
				// totalcost, date);
				// carts.add(c);

				carts.add(new Cart(id, bookid, username, book, img, paid, price, quantity, totalcost, date));
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listBooking", carts);
		request.getRequestDispatcher("/bookingprofile.jsp").forward(request, response);

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
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CART);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to

		response.sendRedirect("http://localhost:8090/GroupProject/BookingServlet/book");
	}

}
