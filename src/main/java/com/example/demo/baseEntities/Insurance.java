package com.example.demo.baseEntities;

import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
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
    @ManyToOne
    protected Employee employee;

    public Insurance(Client client, LocalDate startDate,
                     LocalDate endDate) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Insurance() {
    }
}
