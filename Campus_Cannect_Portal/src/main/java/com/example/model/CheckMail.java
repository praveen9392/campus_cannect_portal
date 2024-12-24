package com.example.model;

public class CheckMail {
	private String email;

	public CheckMail() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CheckMail [email=" + email + "]";
	}

}
