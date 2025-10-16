package com.example.demo.entities;

import com.example.demo.baseEntities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client extends User {
    //osoba ubezpieczona
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    private String city;
    private String address;
    private Integer pesel;
    private String NIP;
    private List<UUID> insuranceList = new ArrayList<>();

    @ManyToOne
    private Employee employee;

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
                  Integer pesel, String NIP,
                  Employee employee) {
        super(name, lastName, phoneNumber, email, userCreds);
        this.city = city;
        this.address = address;
        this.insuranceList = (insuranceList != null) ? insuranceList : new ArrayList<>();
        this.pesel = pesel;
        this.NIP = NIP;
        this.employee = employee;
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
            logger.warn("ID Mismatch: existing ID = {}, provided ID = {}", this.id, client.id);
        }
        return this;
    }

    public void updateInsuranceList(UUID insId) {
        this.insuranceList.add(insId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

