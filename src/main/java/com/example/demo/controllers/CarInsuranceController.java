package com.example.demo.controllers;

import com.example.demo.entities.CarInsurance;
import com.example.demo.services.CarInsuranceService;
import com.example.demo.services.ClientService;
import com.example.demo.viewmodels.CarInsuranceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/car-insurance")
public class CarInsuranceController {
    private final CarInsuranceService carInsuranceService;

    @Autowired
    public CarInsuranceController(CarInsuranceService carInsuranceService, ClientService clientService) {
        this.carInsuranceService = carInsuranceService;
    }

    @PostMapping("/add")
    public ResponseEntity<CarInsuranceDTO> saveInsurance(@RequestBody CarInsurance carInsurance) {
        CarInsuranceDTO response = carInsuranceService.addInsurance(carInsurance);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<CarInsuranceDTO> updateCarInsurance(@RequestBody CarInsurance carInsurance) {
        CarInsuranceDTO response = carInsuranceService.updateInsurance(carInsurance);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<CarInsuranceDTO>> findAll() {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getAll();
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<CarInsuranceDTO>> findByName(@RequestParam UUID id) {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getAllByName(id);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-by-end")
    public ResponseEntity<List<CarInsuranceDTO>> findByEnd(@RequestParam UUID id) {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getEndDateInsurance(id);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }
}
