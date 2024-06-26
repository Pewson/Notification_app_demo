package com.example.demo.entities;

import com.example.demo.interfaces.Insurance;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "car_insurance")
public class CarInsurance extends Insurance {

    private String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarInsurance(Client client, String licensePlate,
                        LocalDate startDate, LocalDate endDate,
                        String ctName, String ctLastname, Integer ctPhone) {
        super(client, startDate, endDate, ctName, ctLastname, ctPhone);
        this.licensePlate = licensePlate;
    }

    public CarInsurance() {
    }

    public CarInsurance update(CarInsurance carInsurance){
        if (this.id.equals(carInsurance.id)){
        this.client = carInsurance.getClient();
        this.licensePlate = carInsurance.getLicensePlate();
        this.startDate = carInsurance.getStartDate();
        this.endDate = carInsurance.getEndDate();
        this.ctName = carInsurance.getCtName();
        this.ctLastname = carInsurance.ctLastname;
        this.ctPhone = carInsurance.ctPhone;
        } else {
            System.out.println("wrong id");
        }
        return this;
    }
}

