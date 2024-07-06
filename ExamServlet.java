

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

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String examID = request.getParameter("examId");
		String examTitle = request.getParameter("title");
		String total_marks = request.getParameter("totalMarks");
		String type = request.getParameter("questionType");
		
		try {
			
		    Class.forName("com.mysql.jdbc.Driver");

		    String url = "jdbc:mysql://localhost:3306/online_exam";

		    Connection con=DriverManager.getConnection(url,"root","root");
		    
		    
		    PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into exam1 values(?,?,?,?)");
		    
		    
		    ps.setString(1, examID);
		    ps.setString(2, examTitle);
		    ps.setString(3, total_marks);
		    ps.setString(4, type);
		    
		    int counter = ps.executeUpdate();
		    
		    if(counter > 0) {
		    	out.println("<h3 align=center>Registered Successfully</h3>");
		    	
		    	response.sendRedirect("succ.html");
		    }
		    else
		    {
		    	out.println("<h3 style='color:red'>Registration failed</h3>");
		    	RequestDispatcher rd = request.getRequestDispatcher("/register1.html");
		    	rd.include(request, response);
		    
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

