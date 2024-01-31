package com.example.demo.entities;

import com.example.demo.interfaces.Insurance;
import com.example.demo.viewmodels.ClientDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private String city;
    private String address;
    private List<UUID> insuranceList;
    private String login;
    private String password;


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

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Client(String name, String lastName,
                  Integer phoneNumber, String email,
                  String city, String address,
                  String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.address = address;
        this.login = login;
        this.password = password;
    }

    public Client() {
    }

    public static Client toEntity(ClientDTO clientDTO, String login, String password){
        return new Client(
                clientDTO.getName(),
                clientDTO.getLastName(),
                clientDTO.getPhoneNumber(),
                clientDTO.getEmail(),
                clientDTO.getCity(),
                clientDTO.getAddress(),
                login,
                password);
    }
}
