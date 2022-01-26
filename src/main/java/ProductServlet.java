
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String SELECT_REVIEW_BY_BOOK = "select * from review where book = ?";
	private static final String INSERT_REVIEW_BY_BOOK = "insert into review(username, reviews, ratings, book, bookid) values(?,?,?,?,?)";
	private static final String SELECT_ALL_PRODUCTS = "select * from product";
	private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
	private static final String INSERT_INTO_CART = "insert into cart (bookid, username, book, img, paid, price, quantity, totalcost ) values(?,?,?,?,?,?,?,?)";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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
	public ProductServlet() {
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

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ProductServlet/productDetail":
				productDetailsPage(request, response);
				break;
			case "/ProductServlet/home":
				listProduct(request, response);
				break;

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
		response.setContentType("text/html;charset=UTF-8");

		int bookid = Integer.parseInt(request.getParameter("id"));
		String book = request.getParameter("title");
		String img = request.getParameter("img");
		int paid = 0; // 0 = unpaid 1= paid
		String price = request.getParameter("price");
		String quantity = "1"; // request.getParameter("quantity");
		String totalcost = "0";

		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String date = df.format(today);

		HttpSession session = request.getSession();
		var username = (String) session.getAttribute("Username");
		System.out.println(username);

		String reviews = request.getParameter("reviews");
		String ratings = request.getParameter("ratings");

		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement(INSERT_INTO_CART);) {
			ps.setInt(1, bookid);
			ps.setString(2, username);
			ps.setString(3, book);
			ps.setString(4, img);
			ps.setInt(5, paid);
			ps.setString(6, price);
			ps.setString(7, quantity);
			ps.setString(8, totalcost);
			// ps.setString(10, date);

			int i = ps.executeUpdate();
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "Added To Cart" + "</h1>");
				writer.close();
			}
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			System.out.close();
		}
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement(INSERT_REVIEW_BY_BOOK);) {

			ps.setString(1, username);
			ps.setString(2, reviews);
			ps.setString(3, ratings);
			ps.setString(4, book);
			ps.setInt(5, bookid);

			int i = ps.executeUpdate();
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "Reviews added" + "</h1>");
				writer.close();
			}
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			System.out.close();
		}
		doGet(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Product> products = new ArrayList<>();

		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String description = rs.getString("description");
				String genre = rs.getString("genre");
				String image = rs.getString("image");
				String price = rs.getString("price");

				products.add(new Product(id, title, author, description, genre, image, price));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listProduct attribute to be pass to the
		// product.jsp
		request.setAttribute("listProduct", products);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing product data and
	// redirect to product detail page
	private void productDetailsPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// get parameter
		int id = Integer.parseInt(request.getParameter("id"));
		int bookid = Integer.parseInt(request.getParameter("id"));

		Product productDetail = new Product(id, "", "", "", "", "", "");
		Review reviewDetail = new Review(id, "", "", "", "", bookid);

//		List<Review> reviews = new ArrayList<>();

		// Step 1: Establish a connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setLong(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String author = rs.getString("author");
				String description = rs.getString("description");
				String genre = rs.getString("genre");
				String image = rs.getString("image");
				String price = rs.getString("price");
				productDetail = new Product(id, title, author, description, genre, image, price);
			}
		}
		// Select reviews
		try (Connection connection2 = getConnection();
				PreparedStatement preparedStatement2 = connection2.prepareStatement(SELECT_REVIEW_BY_BOOK);) {
			preparedStatement2.setLong(1, bookid);
			// Step 3: Execute the query or update query
			ResultSet rs2 = preparedStatement2.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs2.next()) {
				id = Integer.parseInt(rs2.getString("id"));
				String username = rs2.getString("username");
				String book = rs2.getString("title");
				String reviews = rs2.getString("reviews");
				String ratings = rs2.getString("ratings");
				// bookid = Integer.parseInt(rs.getString("bookid"));
				bookid = rs2.getInt("bookid");

				reviewDetail = new Review(id, username, reviews, ratings, book, bookid);
			}
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("product", productDetail);
		request.setAttribute("review", reviewDetail);
		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
		System.out.println(productDetail);
		// System.out.println(reviewDetail);
	}

//	private void listReview(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//
//		List<Review> reviews = new ArrayList<>();
//
//		try (Connection connection = getConnection();
//				// Step 5.1: Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_BOOK);) {
//			// Step 5.2: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//			// Step 5.3: Process the ResultSet object.
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String username = rs.getString("username");
//				String book = rs.getString("title");
//				String review = rs.getString("reviews");
//				String ratings = rs.getString("ratings");
//				int bookid = rs.getInt("bookid");
//
//				reviews.add(new Review(username, review, ratings, book, bookid));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		// Step 5.4: Set the users list into the listProduct attribute to be pass to the
//		// product.jsp
//		request.setAttribute("review", reviews);
//		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
//	}

}
