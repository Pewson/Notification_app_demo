package com.example.demo.baseEntities;

import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
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
    protected BigDecimal totalCostAmount;

    public Insurance(Client client, LocalDate startDate, LocalDate endDate, Employee employee, BigDecimal totalCostAmount) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.totalCostAmount = totalCostAmount;
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

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getTotalCostAmount() {
        return totalCostAmount;
    }

    public Insurance() {
    }
}
