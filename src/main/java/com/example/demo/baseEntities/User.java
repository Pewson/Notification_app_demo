package com.example.demo.baseEntities;


import com.example.demo.entities.UserCreds;
import com.example.demo.global.Role;
import jakarta.persistence.*;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "roleName")
    protected Role role;
    @OneToOne
    protected UserCreds userCreds;

    public User(String name, String lastName, Integer phoneNumber, String email, UserCreds userCreds) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = Role.valueOf(getClassName());
        this.userCreds = userCreds;
    }

    public String getClassName() {
        return this.getClass().getSimpleName().toUpperCase();
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
