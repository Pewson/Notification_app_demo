package com.example.demo.viewmodels;

import com.example.demo.entities.Employee;

import java.util.UUID;

public class EmployeeDTO {
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private UUID managerId;

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

    public UUID getManagerId() {
        return managerId;
    }

    public EmployeeDTO(String name, String lastName, Integer phoneNumber, String email, UUID managerId) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.managerId = managerId;
    }

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getName(),
                employee.getLastName(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getManager().getId());
    }
}
