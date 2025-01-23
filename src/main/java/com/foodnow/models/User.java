package com.foodnow.models;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }



    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;

    }
}