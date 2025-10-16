package com.example.demo.entities;

import com.example.demo.baseEntities.Insurance;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "car_insurance")
public class CarInsurance extends Insurance {

    private String licensePlate;

    private String carBrand;
    private String carModel;
    private String VIN;
    private LocalDate productionDate;
    private Integer engineCapacityCCM;

    public String getLicensePlate() {
        return licensePlate;
    }

    @ManyToOne
    private Employee employee;

    private Client client;

    public CarInsurance(Client client, String licensePlate,
                        LocalDate startDate, LocalDate endDate,
                        String carBrand, String carModel,
                        String VIN, LocalDate productionDate,
                        Integer engineCapacityCCM) {
        super(client, startDate, endDate);
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.VIN = VIN;
        this.productionDate = productionDate;
        this.engineCapacityCCM = engineCapacityCCM;

    }

    public CarInsurance() {
    }

    public CarInsurance update(CarInsurance carInsurance) {
        if (this.id.equals(carInsurance.id)) {
            this.client = carInsurance.getClient();
            this.licensePlate = carInsurance.getLicensePlate();
            this.startDate = carInsurance.getStartDate();
            this.endDate = carInsurance.getEndDate();
        } else {
            System.out.println("wrong id");
        }
        return this;
    }
}

