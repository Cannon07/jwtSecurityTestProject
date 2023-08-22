package com.jpmware.jwtSecurityDemo.auth;

public class AuthenticationResponse {

    private String token;

    // Constructor

    public AuthenticationResponse() {

    }

    // Getters and Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString() method
    
    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
