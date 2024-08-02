

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Farman@123");
			String uname=request.getParameter("username");
			String pass=request.getParameter("pass");
			PreparedStatement pst=con.prepareStatement("select * from users where username=? and password=?");
			pst.setString(1, uname);
			pst.setString(2, pass);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				response.sendRedirect("success.jsp");
			}else {
				response.sendRedirect("fail.jsp");
			}

			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
