

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/formServlet")
public class formServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("name");
		String e = request.getParameter("email");
		String p = request.getParameter("passw1");
		String g = request.getParameter("gender1");
		String u = request.getParameter("userType1");
		
		try {
			
		    Class.forName("com.mysql.jdbc.Driver");

		    String url = "jdbc:mysql://localhost:3306/online_exam";

		    Connection con=DriverManager.getConnection(url,"root","root");
		    
		    
		    PreparedStatement ps = (PreparedStatement) con.prepareStatement("Select * from register where email = ?");
		    
		    ps.setString(1, e);
			ResultSet rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	response.sendRedirect("exist.html");
		    }
		    else
		    {
		    	ps = (PreparedStatement) con.prepareStatement("insert into register values(?,?,?,?,?)");
		    	 ps.setString(1, n);
				 ps.setString(2, e);
				 ps.setString(3, p);
				 ps.setString(4, g);
				 ps.setString(5, u);
				       
				    	
		    	 int counter = ps.executeUpdate();
		    	 if(counter > 0) {
				    //response.setContentType("text/html");
		    		 out.println("<h3 align=center>Sign-up Successfully</h3>");
				    
				    response.sendRedirect("succ.html");
		    	 }
				 else {
					//response.setContentType("text/html");
				    	out.println("<h3 style='color:red'>Sign-up Failed</h3>");
				    	RequestDispatcher rd = request.getRequestDispatcher("/register1.html");
				    	rd.include(request, response);	
				 }
		    	
		    
		    }
		    
		    con.close();
		    ps.close();
		   
		
		}
		catch(Exception e1)
		{
			e1.getMessage();
			
		}
	}

}
