

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

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Farman@123");
			String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String[] courses = request.getParameterValues("courses");
            
            PreparedStatement pst=con.prepareStatement("INSERT INTO users (name, address, email, username, password, gender, courses) VALUES (?, ?, ?, ?, ?, ?,?)");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, email);
            pst.setString(4, username);
            pst.setString(5, password);
            pst.setString(6, gender);

            StringBuilder coursesStr = new StringBuilder();
            if (courses != null && courses.length > 0) {
                for (int i = 0; i < courses.length; i++) {
                    coursesStr.append(courses[i]);
                    if (i < courses.length - 1) {
                        coursesStr.append(", ");
                    }
                }
            }
           pst.setString(7, coursesStr.toString());
            
           
			
			int count = pst.executeUpdate();
			if(count > 0) {
				response.setContentType("text/html");
				out.print("<h3 style= 'color:green'> user register successfully</h3>");
				response.sendRedirect("login.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			} else {
				response.setContentType("text/html");
				out.print("<h3 style= 'color:red'> user not register due to some error</h3>");
				response.sendRedirect("error.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}

			
				
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
