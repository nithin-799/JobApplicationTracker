
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SmartJobTracker")
public class SmartJobTracker extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName = request.getParameter("companyName");
        String jobRole = request.getParameter("jobRole");
        String appliedDate = request.getParameter("appliedDate");
        String status = request.getParameter("status");
        String resumeUsed = request.getParameter("resumeUsed");
        String portal = request.getParameter("portal");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin", "root", "Nithin@123");

            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO jobapplicationtracker " +
                "(company_name, job_role, applied_date, application_status, resume_used, job_portal, location, ctc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, jobRole);
            preparedStatement.setDate(3, java.sql.Date.valueOf(appliedDate)); // safer for DATE column
            preparedStatement.setString(4, status);
            preparedStatement.setString(5, resumeUsed);
            preparedStatement.setString(6, portal);
            preparedStatement.setString(7, location);
            preparedStatement.setString(8, salary);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            response.sendRedirect("success.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
