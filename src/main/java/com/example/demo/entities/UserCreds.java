package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "User_credentials")
public class UserCreds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }


    public UserCreds() {
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserCreds(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}


