package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client extends User {
    private String city;
    private String address;
    private List<UUID> insuranceList = new ArrayList<>();

    public List<UUID> getInsuranceList() {
        return insuranceList;
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
        super(name, lastName, phoneNumber, email);
        this.city = city;
        this.address = address;
        this.login = login;
        this.password = password;
    }

    public Client() {
    }

//    public static Client toEntity(ClientDTO clientDTO, String login, String password){
//        return new Client(
//                clientDTO.getName(),
//                clientDTO.getLastName(),
//                clientDTO.getPhoneNumber(),
//                clientDTO.getEmail(),
//                clientDTO.getCity(),
//                clientDTO.getAddress(),
//                login,
//                password);
//    }

    public Client update(Client client) {
        if (this.id.equals(client.id)){
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

    public void updateInsuranceList(UUID insId){
        this.insuranceList.add(insId);
    }
}
