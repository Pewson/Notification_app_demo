package com.example.demo.viewmodels;

import com.example.demo.entities.CarInsurance;

import java.time.LocalDate;
import java.util.UUID;

public class CarInsuranceDTO {
    private UUID clientId;
    private String licensePlate;
    private LocalDate startDate;
    private LocalDate endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public UUID getClientId() {
        return clientId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public CarInsuranceDTO(UUID clientId, String licensePlate,
                           LocalDate startDate, LocalDate endDate) {
        this.clientId = clientId;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static CarInsuranceDTO toDTO(CarInsurance carInsurance) {
        return new CarInsuranceDTO(
                carInsurance.getClient().getId(),
                carInsurance.getLicensePlate(),
                carInsurance.getStartDate(),
                carInsurance.getEndDate());
    }

}

