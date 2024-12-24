package com.example.model;

public class User {
	private int id; // Unique identifier for the user
	private String email; // User's email
	private String firstName; // User's first name
	private String lastName; // User's last name
	private String rollNo; // User's roll number
	private String password; // User's password

	// Default constructor
	public User() {
	}

	// Constructor with parameters
	public User(String email, String firstName, String lastName, String rollNo, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNo = rollNo;
		this.password = password;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", rollNo=" + rollNo + ", password=" + password + "]";
	}
	// Optional: Override toString() for easier debugging
	
}