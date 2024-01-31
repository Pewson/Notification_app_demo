package com.example.demo.controllers;

import com.example.demo.models.CarInsuranceDTO;
import com.example.demo.services.CarInsuranceService;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-insurance")
public class CarInsuranceController {
    private final CarInsuranceService carInsuranceService;

    @Autowired
    public CarInsuranceController(CarInsuranceService carInsuranceService, ClientService clientService) {
        this.carInsuranceService = carInsuranceService;
    }

    @PostMapping("/add")
    public ResponseEntity<CarInsuranceDTO> saveInsurance(@RequestBody CarInsuranceDTO carInsuranceDTO) {
       CarInsuranceDTO response = carInsuranceService.addInsurance(carInsuranceDTO);
       return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<CarInsuranceDTO>> findAll() {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getAll();
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<CarInsuranceDTO>> findByName(@RequestParam String name){
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getAllByName(name);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-by-end")
    public ResponseEntity<List<CarInsuranceDTO>> findByEnd(@RequestParam String name) {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.getEndDateInsurance(name);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }
}
