package com.example.model;

public class Firstname {
	private String rollno;

	public Firstname() {
	}

	public Firstname(String rollno) {
		super();
		this.rollno = rollno;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Firstname [rollno=" + rollno + "]";
	}

}
