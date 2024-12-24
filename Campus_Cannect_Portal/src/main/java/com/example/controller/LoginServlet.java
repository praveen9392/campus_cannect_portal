package com.example.controller;

import java.io.IOException;

import com.example.DAO.UserImpl;
import com.example.model.AuthenticateUser;
import com.example.model.Firstname;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rollNo = request.getParameter("rollno");
        String password = request.getParameter("password");
        
        AuthenticateUser obj=new AuthenticateUser();
        obj.setRollNo(rollNo);
        obj.setPassword(password);
        
        UserImpl userimpl=new UserImpl();
        boolean status=userimpl.checkIfStudentExists(obj);
        if (status) 
        {
        	System.out.println("Login sucessfull");
        	Firstname firstname=new Firstname();
        	firstname.setRollno(rollNo);
        	
        	String name=userimpl.getbyroll(firstname);
        	HttpSession session=request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("rollNo", rollNo);         
            RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
            req.forward(request, response); // Use forward here
        } 
        else 
        {
            request.setAttribute("errorMessage", "Invalid email or password."); // Set error message
            RequestDispatcher req = request.getRequestDispatcher("login.jsp"); // Forward to login.jsp
            req.forward(request, response); // Use forward here
        }
	}
}
