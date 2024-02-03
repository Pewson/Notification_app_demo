package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import com.example.demo.global.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Employee")
public class Employee extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;
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

    public Manager getManager() {
        return manager;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Employee(){}

    public Employee(String name, String lastName, Integer phoneNumber, String email, Manager manager, List<Client> clientList) {
        super(name, lastName, phoneNumber, email);
        this.manager = manager;
        this.clientList = clientList;
        this.role = Role.EMPLOYEE;
    }

    public Employee update(Employee employee) {
        if (this.id.equals(employee.id)){
            this.name = employee.getName();
            this.lastName = employee.getLastName();
            this.phoneNumber = employee.getPhoneNumber();
            this.email = employee.getEmail();
            this.manager = employee.getManager();
            this.clientList = employee.getClientList();
        } else {
            System.out.println("ID mismatch");
        }
        return this;
    }
}
