package com.example.demo.viewmodels;

import com.example.demo.entities.Manager;

public class ManagerDTO {
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private String email;

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

    public ManagerDTO(String name, String lastName, Integer phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static ManagerDTO toDTO(Manager manager) {
        return new ManagerDTO(
                manager.getName(),
                manager.getLastName(),
                manager.getPhoneNumber(),
                manager.getEmail());
    }
}
