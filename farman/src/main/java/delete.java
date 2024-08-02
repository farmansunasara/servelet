

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		    response.setContentType("text/html");

		    Connection con = null;
		    PreparedStatement pst = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Farman@123");

		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        String query = "DELETE FROM users WHERE username=? AND password=?";
		        pst = con.prepareStatement(query);
		        pst.setString(1, username);
		        pst.setString(2, password);

		        int rowsAffected = pst.executeUpdate();
		        if (rowsAffected > 0) {
		            out.print("<h3 style='color:red'>user deleted successfully</h3>");
		            RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp"); // Stay on the same page
		            rd.include(request, response);

		        } else {
		            out.print("<h3 style='color:red'>No user found with the provided username and password</h3>");
		            RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp"); // Stay on the same page
		            rd.include(request, response);
		        }

		    } catch (Exception e) {
				e.printStackTrace();
				
			} 
	}

}
