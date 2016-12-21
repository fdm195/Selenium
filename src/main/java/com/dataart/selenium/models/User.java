package com.dataart.selenium.models;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String passwordconfirm;
    private String fname;
    private String lname;
    private ArrayList role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(String username,String fname,String lname, String password){
        this.username=username;
        this.fname=fname;
        this.lname=lname;
        this.password=password;



    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole0(){ return (String) role.get(0); }




}
