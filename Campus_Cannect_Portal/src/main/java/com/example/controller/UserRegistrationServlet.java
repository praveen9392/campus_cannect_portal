package com.example.controller;

import java.io.IOException;

import com.example.DAO.UserImpl;
import com.example.model.AuthenticateUser;
import com.example.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String rollNo = request.getParameter("rollno");
        String password = request.getParameter("password");

        // Create a new User object
        User user  = new User();
        user .setEmail(email);
        user .setFirstName(firstName);
        user .setLastName(lastName);
        user .setRollNo(rollNo);
        user .setPassword(password);
        
        AuthenticateUser obj=new AuthenticateUser();
        obj.setRollNo(rollNo);
        obj.setPassword(password);
        
        UserImpl userimpl=new UserImpl();
        boolean status=userimpl.checkIfStudentExists(obj);
        if (status) 
        {
            request.setAttribute("errorMessage", "Student already exists");
            RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
            req.forward(request, response);
        } 
        else 
        {
            String current_status = userimpl.insertStudent(user);
            if (current_status.equals("Success")) 
            {
                response.getWriter().write("Registration successful!");
                RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
                req.forward(request, response);
            } 
            else 
            {
                response.getWriter().write("Registration failed. Try again.");
                RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
                req.forward(request, response);
            }
        }
    }
}
