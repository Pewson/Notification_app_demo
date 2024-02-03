package com.example.demo.baseEntities;

import com.example.demo.entities.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    protected Client client;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate endDate;
    //todo do przerobienia na employee
        protected String ctName;
        protected String ctLastname;
        protected Integer ctPhone;

    public Insurance(Client client, LocalDate startDate,
                     LocalDate endDate, String ctName,
                     String ctLastname, Integer ctPhone) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ctName = ctName;
        this.ctLastname = ctLastname;
        this.ctPhone = ctPhone;
    }

    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
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

    public Insurance() {
    }
}
