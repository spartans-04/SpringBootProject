package com.event.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {
    @Id
    private String username;
    private int mobilenumber;
    private String email;
    private String password;
    public Register() {
        
    }
    public Register(String username, int mobilenumber, String email, String password) {
        this.username = username;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getMobilenumber() {
        return mobilenumber;
    }
    public void setMobilenumber(int mobilenumber) {
        this.mobilenumber = mobilenumber;
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
}
