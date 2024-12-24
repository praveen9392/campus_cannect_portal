package com.example.controller;

import java.io.IOException;

import com.example.DAO.UserImpl;
import com.example.model.CheckMail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        CheckMail checkmail=new CheckMail();
        checkmail.setEmail(email);
        
        UserImpl userimpl=new UserImpl();
        boolean exists = userimpl.checkbyemail(checkmail);

        // Write JSON response
        response.getWriter().write("{\"exists\": " + exists + "}");
	}

}
