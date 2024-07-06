

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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String n = request.getParameter("name");
        String e = request.getParameter("email");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/online_exam";
            Connection con = DriverManager.getConnection(url, "root", "root");

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM register WHERE name = ? AND email = ?");
            ps.setString(1, n);
            ps.setString(2, e);

            ResultSet counter = ps.executeQuery();

            if (counter.next()) {
                // Set attributes
                request.setAttribute("name", n);
                // Assuming there is a column in your table that holds the student record
                request.setAttribute("email", counter.getString("email")); // replace "record" with the actual column name

                // Forward to UserFile.jsp
                RequestDispatcher rd = request.getRequestDispatcher("UserFile.jsp");
                rd.forward(request, response);
            } else {
               
                RequestDispatcher rd = request.getRequestDispatcher("/UserFile.jsp");
                rd.forward(request, response);
            }

            con.close();
            ps.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

