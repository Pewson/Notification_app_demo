package com.example.demo.scheduler;

import com.example.demo.services.CarInsuranceService;
import com.example.demo.viewmodels.CarInsuranceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EndDatesChecker {
    private final CarInsuranceService carInsuranceService;

    @Autowired
    public EndDatesChecker(CarInsuranceService carInsuranceService) {
        this.carInsuranceService = carInsuranceService;
    }

    @Scheduled(cron = "0 59 23 * * ?") // runs every day at 23:59
    public void yourCronScheduledMethod() {
        List<CarInsuranceDTO> endDateCarInsurances = carInsuranceService.findAll().stream()
                .filter(carInsurance ->
                        carInsurance.getEndDate().isBefore(LocalDate.now().plusMonths(1)))
                .toList();
        if (endDateCarInsurances.size() > 0) {
            System.out.println("dziala");
        }
    }
}