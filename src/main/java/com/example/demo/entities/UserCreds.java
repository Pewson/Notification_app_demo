package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import com.example.demo.global.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
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


    public UserCreds(){}

    public void setRole(String role){
        this.role = role;
    }

    public UserCreds(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

}


