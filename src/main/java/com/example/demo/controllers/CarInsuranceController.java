package com.example.demo.controllers;

import com.example.demo.entities.CarInsurance;
import com.example.demo.services.AuthService;
import com.example.demo.services.CarInsuranceService;
import com.example.demo.viewModels.CarInsuranceDTO;
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
    private final AuthService authService;

    @Autowired
    public CarInsuranceController(CarInsuranceService carInsuranceService, AuthService authService) {
        this.carInsuranceService = carInsuranceService;
        this.authService = authService;
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
        List<CarInsuranceDTO> carInsurances = carInsuranceService.findAll();
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-by-ClientId")
    public ResponseEntity<List<CarInsuranceDTO>> findByClientId(@RequestParam UUID id) {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.findAllByClientId(id);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/find-expiring")
    public ResponseEntity<List<CarInsuranceDTO>> findByExpiring(@RequestParam UUID id) {
        List<CarInsuranceDTO> carInsurances = carInsuranceService.findExpiringInsurance(id);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }

    @GetMapping("/my-insurance")
    public ResponseEntity<List<CarInsuranceDTO>> findMyInsurance() {
        /***
        This method retrieves the car insurance policies associated with the currently authenticated client.
        ***/
        UUID myId = authService.getLoggedInClientId();
        List<CarInsuranceDTO> carInsurances = carInsuranceService.findAllByClientId(myId);
        return new ResponseEntity<>(carInsurances, HttpStatus.OK);
    }
}
