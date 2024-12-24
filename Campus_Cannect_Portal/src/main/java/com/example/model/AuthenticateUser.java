package com.example.model;

public class AuthenticateUser 
{
	private String rollNo;
    private String password;
    public AuthenticateUser() {}

    // Constructor
    public AuthenticateUser (String rollNo, String password) {
        this.rollNo = rollNo;
        this.password = password;
    }

    // Getters and Setters
    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "AuthenticateUser [rollNo=" + rollNo + ", password=" + password + "]";
	}
    
}
