package com.example.model;

public class Projects {
	private String rollNo;
    private String projectName;
    private String problemStatement;
    private String technology;
    private String overview;
	public Projects() {
		super();
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProblemStatement() {
		return problemStatement;
	}
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Projects(String rollNo, String projectName, String problemStatement, String technology, String overview) {
		super();
		this.rollNo = rollNo;
		this.projectName = projectName;
		this.problemStatement = problemStatement;
		this.technology = technology;
		this.overview = overview;
	}
	@Override
	public String toString() {
		return "Projects [rollNo=" + rollNo + ", projectName=" + projectName + ", problemStatement=" + problemStatement
				+ ", technology=" + technology + ", overview=" + overview + "]";
	}
	
	
}
