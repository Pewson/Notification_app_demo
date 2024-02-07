package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Client> clientList = new ArrayList<>();

    public Manager getManager() {
        return manager;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Employee(String name, String lastName,
                    Integer phoneNumber, String email, UserCreds userCreds,
                    Manager manager, List<Client> clientList) {
        super(name, lastName, phoneNumber, email, userCreds);
        this.manager = manager;
        this.clientList = clientList;
    }


    public Employee() {
    }

    public Employee update(Employee employee) {
        if (this.id.equals(employee.id)) {
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
