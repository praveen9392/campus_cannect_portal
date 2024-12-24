package com.example.model;

import java.sql.Blob;

public class Profile {

    private String rollno;
    private String name;
    private String email;
    private String phone;
    private String degree;
    private String branch;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Blob profilePhoto;
    private Blob resume;

    public Profile(String rollno, String name, String email, String phone, String degree, String branch,
                   String address, String city, String state, String zip, Blob profilePhoto, Blob resume) {
        this.rollno = rollno;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.degree = degree;
        this.branch = branch;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.profilePhoto = profilePhoto;
        this.resume = resume;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Blob getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Blob profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Blob getResume() {
        return resume;
    }

    public void setResume(Blob resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "rollno='" + rollno + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", degree='" + degree + '\'' +
                ", branch='" + branch + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
