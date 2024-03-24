package project1;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertData") // Servlet mapping
public class InsertDataServlet extends HttpServlet {
    @SuppressWarnings("compatibility:4740675417257510461")
    private static final long serialVersionUID = 1L;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mail ="test";
        int id = 4478;
        String check = insert_data(mail,id);
        // Verify database column data type (INT or BIGINT?)
        //int intId;
        if(check=="success"){
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Data inserted successfully!");
        }
        
        
    }
    public String insert_data(String mail,int id){
        String url = "jdbc:oracle:thin:@localhost:1521:orcle";
        String username = "sys as sysdba";
        String password = "Mortin@245";

        String sql = "INSERT INTO Staffmailid (mail, staff_id) VALUES (?, ?)";

        
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, mail);
            preparedStatement.setInt(2, id); // Assuming INT data type

            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully!");

            // Optional: Set response message
            return "success";

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
          //  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "failure";
        }
    }
}
