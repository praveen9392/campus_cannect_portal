package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.example.model.AuthenticateUser;
import com.example.model.CheckMail;
import com.example.model.Firstname;
import com.example.model.Internship;
import com.example.model.Projects;
import com.example.model.User;
import com.example.utility.DBConnection;

public class UserImpl implements UserInterface {
	@Override
	public String insertStudent(User user) {
		String status = "Something went wrong";
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			// Use executeUpdate for INSERT statements
			PreparedStatement pt = conn.prepareStatement(
					"INSERT INTO users (email, first_name, last_name, rollno, password) VALUES (?, ?, ?, ?, ?)");

			// Set parameters from the User object
			pt.setString(1, user.getEmail());
			pt.setString(2, user.getFirstName());
			pt.setString(3, user.getLastName());
			pt.setString(4, user.getRollNo());
			pt.setString(5, user.getPassword());

			int rowsAffected = pt.executeUpdate(); // executeUpdate returns the number of affected rows
			if (rowsAffected > 0) {
				status = "Success";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public boolean checkIfStudentExists(AuthenticateUser authorize) {
		boolean exists = false;
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			// Use executeUpdate for INSERT statements
			PreparedStatement pt = conn.prepareStatement("select * from users where rollno=? and password=?");

			// Set parameters from the User object
			pt.setString(1, authorize.getRollNo());
			pt.setString(2, authorize.getPassword());
			ResultSet rs = pt.executeQuery();
			if (rs.next()) { // If a record with the same email is found
				exists = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	@Override
	public String getbyroll(Firstname firstname) {
		String name = null; // Initialize name to null

		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			PreparedStatement pt = conn.prepareStatement("SELECT first_name FROM users WHERE rollno = ?");

			// Set the rollno parameter from the Firstname object
			pt.setString(1, firstname.getRollno());

			// Execute the query
			ResultSet rs = pt.executeQuery();

			// Check if a record exists and retrieve the firstname
			if (rs.next()) {
				name = rs.getString("first_name"); // Get the firstname from the ResultSet
				System.out.println(name);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return name;
	}

	@Override
	public boolean checkbyemail(CheckMail checkmail) {
		boolean exists = false;
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			// Use executeUpdate for INSERT statements
			PreparedStatement pt = conn.prepareStatement("select * from emails where email=?");
			pt.setString(1, checkmail.getEmail());
			ResultSet rs = pt.executeQuery();
			if (rs.next()) 
			{
				exists = true;
				System.out.println(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	@Override
	public String updateByProject(Projects projects) {
	    String status = null;
	    try {
	        // Establish database connection
	        DBConnection db = new DBConnection();
	        Connection conn = db.getConnection();

	        // Check if the project exists
	        String checkQuery = "SELECT COUNT(*) FROM Projects WHERE rollNo = ? AND projectName = ?";
	        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
	        checkStmt.setString(1, projects.getRollNo());
	        checkStmt.setString(2, projects.getProjectName());
	        ResultSet rs = checkStmt.executeQuery();

	        boolean exists = false;
	        if (rs.next()) {
	            exists = rs.getInt(1) > 0;
	        }

	        if (exists) {
	            // Update existing record
	            String updateQuery = "UPDATE Projects SET problemStatement = ?, technology = ?, overview = ? WHERE rollNo = ? AND projectName = ?";
	            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	            updateStmt.setString(1, projects.getProblemStatement());
	            updateStmt.setString(2, projects.getTechnology());
	            updateStmt.setString(3, projects.getOverview());
	            updateStmt.setString(4, projects.getRollNo());
	            updateStmt.setString(5, projects.getProjectName());

	            updateStmt.executeUpdate();
	            status = "Updated successfully";
	            System.out.println(status);
	            updateStmt.close(); // Close PreparedStatement
	        } else {
	            // Insert new record
	            String insertQuery = "INSERT INTO Projects (rollNo, projectName, problemStatement, technology, overview) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
	            insertStmt.setString(1, projects.getRollNo());
	            insertStmt.setString(2, projects.getProjectName());
	            insertStmt.setString(3, projects.getProblemStatement());
	            insertStmt.setString(4, projects.getTechnology());
	            insertStmt.setString(5, projects.getOverview());

	            insertStmt.executeUpdate();
	            status = "Project added successfully";
	            System.out.println(status);
	            insertStmt.close(); // Close PreparedStatement
	        }

	        // Close resources
	        rs.close();
	        checkStmt.close();
	        conn.close();
	    } catch (Exception e) {
	        status = "Error: " + e.getMessage();
	        System.out.println(status);
	    }
	    return status;
	}
	public String updateByInternship(Internship internship) {
	    // Implement the logic to insert or update the internship data in the database
	    // Example: Use JDBC to interact with the database
	    try {
	    	DBConnection db = new DBConnection();
	        Connection conn = db.getConnection();
	        String query = "INSERT INTO internships (roll_no, internship_name, role, company, skills) VALUES (?, ?, ?, ?, ?)";
	        
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, internship.getRollNo());
	        ps.setString(2, internship.getInternshipName());
	        ps.setString(3, internship.getRole());
	        ps.setString(4, internship.getCompany());
	        ps.setString(5, internship.getSkills());
	       

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            return "internship added successfully";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "Something went wrong";
	}


}
