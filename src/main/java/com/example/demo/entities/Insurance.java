package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String lastname;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer clientPhone;
    private String ctName;
    private String ctLastname;
    private Integer ctPhone;

    public UUID getId() {
        return id;
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

    public LocalDate getEndDateDate() {
        return endDate;
    }

    public Insurance() {
    }
}

