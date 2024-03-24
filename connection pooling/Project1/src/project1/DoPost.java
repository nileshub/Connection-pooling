package project1;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//@WebServlet("/InsertData")
public class DoPost{
    @SuppressWarnings("compatibility:-1443683667206846593")
//    private static final long serialVersionUID = 1L;

    //    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public void post(String mail,String id){
        String url;
        url =
            "jdbc:mysql://localhost:3306/icsdbs?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        // Replace with table and column names, and data to insert
        String sql = "INSERT INTO Staff_mail (mail_id, staff_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
   public static void main(String[] args){
        // Replace with your connection details
        DoPost myObject = new DoPost();
        myObject.post("test", "4679");
    }
}
