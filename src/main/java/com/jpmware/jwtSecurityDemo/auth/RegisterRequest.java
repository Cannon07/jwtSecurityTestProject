package com.jpmware.jwtSecurityDemo.auth;

public class RegisterRequest {

    // Fields

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Constructors

    public RegisterRequest () {

    }

    public RegisterRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString() method

    @Override
    public String toString() {
        return "RegisterRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + "]";
    }    
    
}
