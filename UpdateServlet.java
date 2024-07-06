

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("type"))) {
            response.sendRedirect("loginn.html");
            return;
        }

        String exam_id = request.getParameter("examId");
        String total_marks = request.getParameter("totalMarks");
        
        int totalMarks = Integer.parseInt(total_marks);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	Class.forName("com.mysql.jdbc.Driver");

		    String url = "jdbc:mysql://localhost:3306/online_exam";

		    Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps = con.prepareStatement("UPDATE exam1 SET totalMarks = ? WHERE examId = ?");

            ps.setString(1, total_marks);
            ps.setString(2, exam_id );
            

            int counter = ps.executeUpdate();
		    
            if (counter > 0) {
                // Set attributes for the success page
                request.setAttribute("examId", exam_id);
                request.setAttribute("totalMarks", totalMarks);
                RequestDispatcher rd = request.getRequestDispatcher("register!.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h3 style='color:red'>Update Failed</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
                rd.forward(request, response);
            }

            ps.close();
            con.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            out.println("<h3 style='color:red'>An error occurred: " + e1.getMessage() + "</h3>");
        }
    }
}

