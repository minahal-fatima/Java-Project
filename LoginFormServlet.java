

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		String myEmail = request.getParameter("email");
		String myPass = request.getParameter("passw1");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/online_exam";
			Connection con = DriverManager.getConnection(url, "root", "root");

			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, myEmail);
			ps.setString(2, myPass);

			ResultSet rs = (ResultSet) ps.executeQuery();

			if (rs.next()) {
				HttpSession session = request.getSession();
				String userType = rs.getString("userType"); 
				session.setAttribute("type", userType);
				session.setAttribute("myEmail", myEmail);
				if ("admin".equals(userType)) {
					response.sendRedirect("admin.jsp");
				} else if ("user".equals(userType)) {
					response.sendRedirect("User.jsp");
				}
			} else {
				out.println("<h3 style='color:red'>Login Failed</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/loginn.html");
				rd.include(request, response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}


