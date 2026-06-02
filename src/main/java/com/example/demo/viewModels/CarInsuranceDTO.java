package com.example.demo.viewModels;

import com.example.demo.entities.CarInsurance;

import java.time.LocalDate;
import java.util.UUID;

public class CarInsuranceDTO {
    private UUID clientId;
    private String licensePlate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String VIN;
    private LocalDate productionDate;
    private Integer engineCapacityCCM;


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
                           LocalDate startDate, LocalDate endDate,
                           String VIN, LocalDate productionDate, Integer engineCapacityCCM) {
        this.clientId = clientId;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.VIN = VIN;
        this.productionDate = productionDate;
        this.engineCapacityCCM = engineCapacityCCM;

    }

    public static CarInsuranceDTO toDTO(CarInsurance carInsurance) {
        return new CarInsuranceDTO(
                carInsurance.getClient().getId(),
                carInsurance.getLicensePlate(),
                carInsurance.getStartDate(),
                carInsurance.getEndDate(),
                carInsurance.getVIN(),
                carInsurance.getProductionDate(),
                carInsurance.getEngineCapacityCCM());
    }

}

