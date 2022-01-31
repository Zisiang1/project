
import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String SELECT_ALL_CART_BY_USERNAME_AND_UNPAID = "select * from cart where username = ? and paid=0";
	private static final String DELETE_CART = "delete from cart where id=?";
	private static final String SELECT_ALL_CART = "select * from cart";
	private static final String INSERT_INTO_BOOKING = "INSERT INTO booking (username, book, quantity, price) VALUES (?,?,?,?)";
	private static final String UPDATE_CART_PAID = "update cart set paid=1 where id=?";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via
	// JDBC
	List<Cart> carts = new ArrayList<>();


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
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the
		// follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/CartServlet/cart":
				listCart(request, response);
				break;
			case "/CartServlet/pay":
				payCart(request, response);
				break;

			case "/CartServlet/delete":
				deleteCart(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CART);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to

		response.sendRedirect("http://localhost:8090/GroupProject/cart.jsp");
	}

	private void payCart(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pay.jsp").forward(request, response);

	}

	private void listCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		var user = (String) session.getAttribute("Username");
		
		carts.clear();

		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_ALL_CART_BY_USERNAME_AND_UNPAID);) {
			preparedStatement.setString(1, user);
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
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
		request.setAttribute("listCart", carts);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		int bookid = 0;
		String username = "";
		String book = "";
		String img = "";
		String paid = "";
		String price = "";
		String quantity = "";
		String totalcost = "";
		String date = "";

		for (int i = 0; i < carts.size(); i++) {
			id = carts.get(i).getid();
			bookid = carts.get(i).getBookid();
			username = carts.get(i).getUsername();
			book = carts.get(i).getBook();
			img = carts.get(i).getImg();
			paid = carts.get(i).getPaid();
			price = carts.get(i).getPrice();
			quantity = carts.get(i).getQuantity();
			totalcost = carts.get(i).getTotalcost();
			date = carts.get(i).getDate();

//			PrintWriter writer = response.getWriter();
//			writer.println("<h1>" + id + "</h1>");
//			writer.close();
//			System.out.println(id);

			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement ps = connection.prepareStatement(INSERT_INTO_BOOKING);) {
				ps.setString(1, username);
				ps.setString(2, book);
				ps.setString(3, quantity);
				ps.setString(4, price);

				int x = ps.executeUpdate();
			}
			// Step 8: catch and print out any exception
			catch (Exception exception) {
				System.out.println(exception);
				System.out.close();
			}

			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_CART_PAID);) {
				statement.setInt(1, id);
				int y = statement.executeUpdate();
			}
			// Step 8: catch and print out any exception
			catch (Exception exception) {
				System.out.println(exception);
				System.out.close();
			}

		}
		response.sendRedirect("http://localhost:8090/GroupProject/ProductServlet/home");

	}
}
