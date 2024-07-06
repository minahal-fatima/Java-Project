

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserExamServlet")
public class UserExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	String action = request.getParameter("action");
//
//        if ("takeExam".equals(action)) {
//            takeExam(request, response);
//        }
//    }
//
//    private void takeExam(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String exam_id = request.getParameter("examId");
        String titlee = request.getParameter("title");
        String total_marks = request.getParameter("totalMarks");
        String question_type = request.getParameter("questionType");
        try {
        	Class.forName("com.mysql.jdbc.Driver");

		    String url = "jdbc:mysql://localhost:3306/online_exam";

		    Connection con=DriverManager.getConnection(url,"root","root");
		    
		    PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into question values(?,?,?,?)");
		    
            ps.setString(1, exam_id);
            ps.setString(2, titlee);
            ps.setString(3, total_marks);
            ps.setString(4, question_type);

            int counter = ps.executeUpdate();
            if (counter > 0) {
                
                
                response.sendRedirect("takeExam.html");
                
            } else
		    {
		    	RequestDispatcher rd = request.getRequestDispatcher("/loginn.html");
		    	rd.include(request, response);
		    
		    }
		    
		    con.close();
		    ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

 
}

