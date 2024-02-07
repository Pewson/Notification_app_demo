package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client extends User {
    private String city;
    private String address;
    private List<UUID> insuranceList = new ArrayList<>();

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Manager manager;

    private UserCreds userCreds;

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Client(String name, String lastName,
                  Integer phoneNumber, String email, UserCreds userCreds,
                  String city, String address,
                  List<UUID> insuranceList,
                  Employee employee, Manager manager,
                  UserCreds userCreds1) {
        super(name, lastName, phoneNumber, email, userCreds);
        this.city = city;
        this.address = address;
        this.insuranceList = insuranceList;
        this.employee = employee;
        this.manager = manager;
        this.userCreds = userCreds1;
    }

    public Client() {
    }

    public Client update(Client client) {
        if (this.id.equals(client.id)) {
            this.name = client.getName();
            this.lastName = client.getLastName();
            this.phoneNumber = client.getPhoneNumber();
            this.email = client.getEmail();
            this.city = client.getCity();
            this.address = client.getAddress();
        } else {
            System.out.println("ID mismatch");
        }
        return this;
    }

    public void updateInsuranceList(UUID insId) {
        this.insuranceList.add(insId);
    }
}
