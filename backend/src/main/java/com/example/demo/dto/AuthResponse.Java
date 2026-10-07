package com.example.demo.dto;

import com.example.demo.Entity.AppUser;

public class AuthResponse {
    // Implement authentication logic here
    private String msg = "You logged in successfully! Welcome to the Employee Management System!";
    private String username;

    public AuthResponse(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg + username;
    }
}