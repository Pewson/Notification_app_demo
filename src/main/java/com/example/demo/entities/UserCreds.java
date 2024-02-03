package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name = "User_credentials")
public class UserCreds {
    private UUID id;
    private String email;
    private String login;
    private String password;
}
