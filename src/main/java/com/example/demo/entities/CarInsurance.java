package com.example.demo.entities;

import com.example.demo.models.CarInsuranceDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "car_insurance")
public class CarInsurance {
    //todo wyjebac name lastname
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    private String name;
    private String lastname;
    private String licensePlate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer clientPhone;
    private String ctName;
    private String ctLastname;
    private Integer ctPhone;


    public UUID getId() {
        return id;
    }

    public Client getUniqueClientId() {
        return client;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLicensePlate() {
        return licensePlate;
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

    public CarInsurance(Client client, String name,
                        String lastname, String licensePlate,
                        LocalDate startDate, LocalDate endDate,
                        Integer clientPhone, String ctName,
                        String ctLastname, Integer ctPhone) {
        this.client = client;
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

    public CarInsurance() {
    }

    public static CarInsurance toEntity(CarInsuranceDTO carInsuranceDTO, Client client){
        return new CarInsurance(
                client,
                carInsuranceDTO.getName(),
                carInsuranceDTO.getLastname(),
                carInsuranceDTO.getLicensePlate(),
                carInsuranceDTO.getStartDate(),
                carInsuranceDTO.getEndDate(),
                carInsuranceDTO.getClientPhone(),
                carInsuranceDTO.getCtName(),
                carInsuranceDTO.getLastname(),
                carInsuranceDTO.getCtPhone());
    }
}

