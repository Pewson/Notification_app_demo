package com.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Entity
@Table(name = "User_credentials")
public class UserCreds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;
    private String password;

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

    public UserCreds(String username, String password) {
        this.username = username;
        this.password = encodePassword(password);
    }

    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

}


