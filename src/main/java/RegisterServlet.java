

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
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
		System.out.println("abc");
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("name");
        String p = request.getParameter("password");
        String e = request.getParameter("email");
        String a = request.getParameter("address");
        String a2 = request.getParameter("address2");
        String c = request.getParameter("city");
        String s = request.getParameter("state");
        String z = request.getParameter("zip");
        String p2 = request.getParameter("phone");
        String d = request.getParameter("date");
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/bookstore", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?)");
             
             ps.setString(1, n);
             ps.setString(2, p);
             ps.setString(3, d);
             ps.setString(4, e);
             ps.setString(5, p2);
             ps.setString(6, a);
             ps.setString(7, a2);
             ps.setString(8, c);
             ps.setString(9, s);
             ps.setString(10, z);
             int i = ps.executeUpdate();
             if (i > 0){
                 PrintWriter writer = response.getWriter();
                 writer.println("<h1>" + "You have successfully registered an account!" +
                 "</h1>");
                 writer.close();
             }
        }
        catch (Exception exception) {
             System.out.println(exception);
             out.close();
            }
		doGet(request, response);
	}

}
