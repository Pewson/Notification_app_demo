package com.example.demo.controllers;

import com.example.demo.entities.Insurance;
import com.example.demo.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Insurance> saveInsurance(@RequestBody Insurance insurance) {
       Insurance response = insuranceService.addInsurnace(insurance);
       return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Insurance>> findAll() {
        List<Insurance> insurances = insuranceService.getAll();
        return new ResponseEntity<>(insurances, HttpStatus.OK);
    }
    @GetMapping("/findByEnd")
    public ResponseEntity<List<Insurance>> findByEnd(@RequestParam String name) {
        List<Insurance> insurances = insuranceService.getEndDateInsurance(name);
        return new ResponseEntity<>(insurances, HttpStatus.OK);
    }
}
