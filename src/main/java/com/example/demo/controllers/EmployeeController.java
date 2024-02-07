package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;
import com.example.demo.viewmodels.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody Employee employee) {
        EmployeeDTO response = employeeService.addEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee employee) {
        EmployeeDTO response = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employees = employeeService.findAll();
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<List<EmployeeDTO>> findByID(@RequestParam UUID id) {
        List<EmployeeDTO> employees = employeeService.findById(id);
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
    }
}
