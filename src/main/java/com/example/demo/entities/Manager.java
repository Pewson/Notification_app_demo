package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Manager")
public class Manager extends User {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Client> clientList = new ArrayList<>();


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Manager() {
    }

    public Manager(String name, String lastName,
                   Integer phoneNumber, String email, UserCreds userCreds,
                   List<Employee> employeeList, List<Client> clientList) {
        super(name, lastName, phoneNumber, email, userCreds);
        this.employeeList = employeeList;
        this.clientList = clientList;
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
}
