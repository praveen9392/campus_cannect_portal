package com.example.controller;

import java.io.IOException;

import com.example.DAO.UserImpl;
import com.example.model.Projects;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
        String rollNo = (String) session.getAttribute("rollNo");
        System.out.println(rollNo);
		String projectName=request.getParameter("projectname");
		String problemStatement=request.getParameter("ProblemStatement");
		String technology=request.getParameter("technology");
		String overview=request.getParameter("overview");
		
		Projects projects=new Projects();
		projects.setRollNo(rollNo);
		projects.setProjectName(projectName);
		projects.setProblemStatement(problemStatement);
		projects.setTechnology(technology);
		projects.setOverview(overview);
		
		UserImpl userimpl=new UserImpl();
		String status=userimpl.updateByProject(projects);
		System.out.println(status);
		if(status.equals("updated sucessfully"))
		{
			request.setAttribute("Message", "updated sucessfully");
            RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
            req.forward(request, response);
		}
		else if(status.equals("project added sucessfully"))
		{
			request.setAttribute("Message", "Project added Sucessfully");
            RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
            req.forward(request, response);
		}
		else {
			request.setAttribute("Message", "Something is wrong,check details");
            RequestDispatcher req = request.getRequestDispatcher("/Projects.jsp");
            req.forward(request, response);
		}
	}
}
