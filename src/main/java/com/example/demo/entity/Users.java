package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String username;
    private String password;
    private String email;
    
    public Users(String username, String password, String email, long id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Users [username=" + username + ", password=" + password + ", email=" + email + ", id=" + id + "]";
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}


