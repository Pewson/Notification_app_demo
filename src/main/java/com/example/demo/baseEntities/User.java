package com.example.demo.baseEntities;


import com.example.demo.entities.UserCreds;
import com.example.demo.global.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    protected String name;
    protected String lastName;
    protected Integer phoneNumber;
    protected String email;
    protected Role role;
    protected UserCreds userCreds;

    public User(String name, String lastName, Integer phoneNumber, String email, Role role, UserCreds userCreds) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.userCreds = userCreds;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public UserCreds getUserCreds() {
        return userCreds;
    }
}
