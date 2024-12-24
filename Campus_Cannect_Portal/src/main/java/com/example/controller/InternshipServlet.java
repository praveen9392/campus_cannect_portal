package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.example.DAO.UserImpl;
import com.example.model.Internship;

/**
 * Servlet implementation class InternshipServlet
 */
@WebServlet("/Internship")
public class InternshipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve session information
        HttpSession session = request.getSession(false);
        String rollNo = (String) session.getAttribute("rollNo");
        System.out.println("Roll Number: " + rollNo);
        
        // Retrieve form data
        String internshipName = request.getParameter("internshipname");
        String role = request.getParameter("role");
        String company = request.getParameter("company");
        String skills = request.getParameter("skills");
        
        // Map data to Internship model
        Internship internship = new Internship();
        internship.setRollNo(rollNo);
        internship.setInternshipName(internshipName);
        internship.setRole(role);
        internship.setCompany(company);
        internship.setSkills(skills);
        
        // Call DAO to save/update internship details
        UserImpl userImpl = new UserImpl();
        String status = userImpl.updateByInternship(internship);
        System.out.println("Operation Status: " + status);
        
        // Handle response based on the operation's result
        if ("updated successfully".equalsIgnoreCase(status)) {
            request.setAttribute("Message", "Internship details updated successfully.");
            RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
            req.forward(request, response);
        } else if ("internship added successfully".equalsIgnoreCase(status)) {
            request.setAttribute("Message", "Internship added successfully.");
            RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
            req.forward(request, response);
        } else {
            request.setAttribute("Message", "Something went wrong. Please check the details.");
            RequestDispatcher req = request.getRequestDispatcher("/Internship.jsp");
            req.forward(request, response);
        }
	}

}
