package com.example.DAO;

import com.example.model.AuthenticateUser;
import com.example.model.CheckMail;
import com.example.model.Firstname;
import com.example.model.Projects;
import com.example.model.User;

public interface UserInterface 
{
	public String insertStudent(User user);
    public boolean checkIfStudentExists(AuthenticateUser authorize);
    public String getbyroll(Firstname firstname);
    public boolean checkbyemail(CheckMail checkmail);
    public String updateByProject(Projects projects);
}
