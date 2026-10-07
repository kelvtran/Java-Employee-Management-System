package com.example.demo.service;

import com.example.demo.Entity.AppUser;

public class AuthService {
    // Implement authentication logic here
    private String msg = "You logged in successfully! Welcome to the Employee Management System!";

    public String getMsg() {
        return msg + AppUser.getFirstname() + " " + AppUser.getLastname();
    }
}