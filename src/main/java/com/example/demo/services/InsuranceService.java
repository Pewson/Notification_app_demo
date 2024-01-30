package com.example.demo.services;

import com.example.demo.entities.Insurance;
import com.example.demo.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance addInsurnace(Insurance insurance){
        return insuranceRepository.save(insurance);
    }

    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    public List<Insurance> getEndDateInsurance(String name) {
        return (List<Insurance>) insuranceRepository.findInsuranceByEndDate(name);
    }
}
