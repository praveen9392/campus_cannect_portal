package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.utility.DBConnection;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // Retrieve the session
        HttpSession session = request.getSession(false);
        String rollNo = (String) session.getAttribute("rollNo");
        System.out.println(rollNo);
		
//        System.out.println(request.getParameter("name"));
//        System.out.println(request.getParameter("email"));
//        System.out.println(request.getParameter("phone"));
//        System.out.println(request.getParameter("degree"));
//        System.out.println(request.getParameter("branch"));
//        System.out.println(request.getParameter("address"));
//        System.out.println(request.getParameter("city"));
//        System.out.println(request.getParameter("state"));
//        System.out.println(request.getParameter("zip"));
        

//         If rollNo is null, redirect to the login page
        if (rollNo == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            // Query to check if the user already exists in the profile table
	            String query = "SELECT * FROM profiles WHERE rollno = ?";
	            PreparedStatement pt = conn.prepareStatement(query);
	            pt.setString(1, rollNo);
	
	            ResultSet rs = pt.executeQuery();
	
	             boolean status=false;
	            if (rs.next()) 
	            {
	                // User exists, update the profile
	                status=updateProfile(request, conn, rollNo);
	            } else {
//	                 User does not exist, create a new profile
	                status=createProfile(request, conn, rollNo);
	            }
	            if(status)
	            {
	            	RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
	                req.forward(request, response);
	            }
	
	            
	
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred");
	        }
	    }
	
	    private boolean updateProfile(HttpServletRequest request, Connection conn, String rollNo) throws SQLException, IOException, ServletException {
	        // Get data from the form
	    	boolean status=false;
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String degree = request.getParameter("degree");
	        String branch = request.getParameter("branch");
	        String address = request.getParameter("address");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String zip = request.getParameter("zip");
	        String cgpa = request.getParameter("cgpa");
	        String summary = request.getParameter("summary");
	
	
	        // Prepare the SQL update statement
	        String updateQuery = "UPDATE profiles SET name = ?, email = ?, phone = ?, degree = ?, branch = ?, "
	                + "address = ?, city = ?, state = ?, zip = ?, cgpa = ?, summary = ? WHERE rollno = ?";
	
	        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	            updateStmt.setString(1, name);
	            updateStmt.setString(2, email);
	            updateStmt.setString(3, phone);
	            updateStmt.setString(4, degree);
	            updateStmt.setString(5, branch);
	            updateStmt.setString(6, address);
	            updateStmt.setString(7, city);
	            updateStmt.setString(8, state);
	            updateStmt.setString(9, zip);
	            updateStmt.setString(10, cgpa);
	            updateStmt.setString(11, summary);
	
	            updateStmt.setString(12, rollNo); // Set rollNo for WHERE clause
	            updateStmt.executeUpdate();
	            status=true;
	        }
			return status;
	    }
	
	    private boolean createProfile(HttpServletRequest request, Connection conn, String rollNo) 
	            throws SQLException, IOException, ServletException {
	        // Get data from the form
	    	boolean status=false;
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String degree = request.getParameter("degree");
	        String branch = request.getParameter("branch");
	        String address = request.getParameter("address");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String zip = request.getParameter("zip");
	        String cgpa = request.getParameter("cgpa");
	        String summary = request.getParameter("summary");
	        
	        System.out.println("Name: " + name); // Helps trace missing or null values
	

//         Validate fields
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        
        String insertQuery = "INSERT INTO profiles (rollno, name, email, phone, degree, branch, address, city, state, zip, cgpa, summary) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, rollNo);
            insertStmt.setString(2, name);
            insertStmt.setString(3, email);
            insertStmt.setString(4, phone);
            insertStmt.setString(5, degree);
            insertStmt.setString(6, branch);
            insertStmt.setString(7, address);
            insertStmt.setString(8, city);
            insertStmt.setString(9, state);
            insertStmt.setString(10, zip);
            insertStmt.setString(11, cgpa);
            insertStmt.setString(12, summary);
            insertStmt.executeUpdate();
            status=true;
        }
		return status;
    }
}
