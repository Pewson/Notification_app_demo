package com.example.demo.viewmodels;

import com.example.demo.entities.Client;
//todo maskowanie hasla/loginu
public class ClientDTO {
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private String City;
    private String address;

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

    public String getCity() {
        return City;
    }

    public String getAddress() {
        return address;
    }

    public ClientDTO(String name, String lastName, Integer phoneNumber, String email, String city, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        City = city;
        this.address = address;
    }

    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(
                client.getName(),
                client.getLastName(),
                client.getPhoneNumber(),
                client.getEmail(),
                client.getCity(),
                client.getAddress());
    }
}

