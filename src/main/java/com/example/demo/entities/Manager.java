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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Manager(){
        this.role = Role.MANAGER;
    }

    public Manager(String name, String lastName,
                   Integer phoneNumber, String email, UserCreds userCreds,
                   List<Employee> employeeList) {
        super(name, lastName, phoneNumber, email, userCreds);
        this.role = Role.MANAGER;
        this.employeeList = employeeList;
    }


    public Manager update(Manager manager) {
        if (this.id.equals(manager.id)) {
            this.name = manager.getName();
            this.lastName = manager.getLastName();
            this.phoneNumber = manager.getPhoneNumber();
            this.email = manager.getEmail();
            this.employeeList = manager.getEmployeeList();
        } else {
            System.out.println("ID Mismatch");
        }
        return this;
    }


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
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public UserCreds getUserCreds() {
        return super.getUserCreds();
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
