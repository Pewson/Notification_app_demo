package com.example.demo.viewModels;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class CarDescriptionModel {

    /***
     * Model used for CollectiveCarInsurance to store information about cars.
     */
    private String licensePlate;
    private String carBrand;
    private String carModel;
    private String VIN;
    private LocalDate productionDate;
    private Integer engineCapacity;

    public CarDescriptionModel(String licensePlate, String carBrand, String carModel, String VIN, LocalDate productionDate, Integer engineCapacity) {
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.VIN = VIN;
        this.productionDate = productionDate;
        this.engineCapacity = engineCapacity;
    }
    public CarDescriptionModel() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getVIN() {
        return VIN;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }
}
