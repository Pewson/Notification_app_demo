package com.example.demo.models;

import com.example.demo.entities.CarInsurance;

import java.time.LocalDate;
import java.util.UUID;

public class CarInsuranceDTO {
    private UUID clientId;
    private String name;
    private String lastname;
    private String licensePlate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer clientPhone;
    private String ctName;
    private String ctLastname;
    private Integer ctPhone;

    public UUID getClient() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getClientPhone() {
        return clientPhone;
    }

    public String getCtName() {
        return ctName;
    }

    public String getCtLastname() {
        return ctLastname;
    }

    public Integer getCtPhone() {
        return ctPhone;
    }

    public CarInsuranceDTO(UUID clientId, String name,
                           String lastname, String licensePlate,
                           LocalDate startDate, LocalDate endDate,
                           Integer clientPhone, String ctName,
                           String ctLastname, Integer ctPhone) {
        this.clientId = clientId;
        this.name = name;
        this.lastname = lastname;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientPhone = clientPhone;
        this.ctName = ctName;
        this.ctLastname = ctLastname;
        this.ctPhone = ctPhone;
    }

    public static CarInsuranceDTO toDTO(CarInsurance carInsurance){
        return new CarInsuranceDTO(
                carInsurance.getUniqueClientId().getId(),
                carInsurance.getName(),
                carInsurance.getLastname(),
                carInsurance.getLicensePlate(),
                carInsurance.getStartDate(),
                carInsurance.getEndDate(),
                carInsurance.getClientPhone(),
                carInsurance.getCtName(),
                carInsurance.getCtLastname(),
                carInsurance.getCtPhone());
    }

}

