package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import com.example.demo.global.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Manager")
public class Manager extends User {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Client> clientList = new ArrayList<>();


    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Integer getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

}
